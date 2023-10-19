package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.mapper.UsersMapper;
import cn.blockengine.ftcloudmessage.response.UserResponse;
import cn.blockengine.ftcloudmessage.service.PayService;
import cn.blockengine.ftcloudmessage.service.UsersService;
import cn.blockengine.ftcloudmessage.utils.RedisUtil;
import cn.blockengine.ftcloudmessage.utils.WxUtils;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.exception.HttpCodeException;
import com.wechat.pay.contrib.apache.httpclient.exception.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
@Slf4j
public class PayServiceImpl extends BaseService implements PayService {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UsersMapper usersMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    public JSONObject createPay(Long orderId, String price, String type) {
        // 获取用户ID

        Long userId = getUserId();

        // 获取用户
        UserResponse user = usersMapper.getUserByUserId(userId);

        // 自动获取微信证书
        CloseableHttpClient httpClient = buildHttpClient();

        String wechatAppId = "wxb87355b683322bcb";
        String merchantId = "1651675178";

        // 构建订单数据
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();

        // 生成订单号
        String wx_no = UUID.randomUUID().toString().replaceAll("-", "");

        // 构建微信支付请求体
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", merchantId)
                .put("appid", wechatAppId)
                .put("description", "产品收费 - 方糖来信")
                .put("notify_url", "https://water.asugar.cn/notify")
                .put("out_trade_no", wx_no);
        rootNode.putObject("amount")
                .put("total", Integer.parseInt(price));
        rootNode.putObject("payer")
                .put("openid", user.getOpenId());
        objectMapper.writeValue(bos, rootNode);

        httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSON.parseObject(res);
        log.info("微信支付回调信息 ->" + jsonObject);

        JSONObject resData = new JSONObject();
        resData.put("prepay_id", jsonObject.get("prepay_id"));
        resData.put("wx_no", wx_no);

        // 记录订单, 这里只是记录生成了这笔支付, 并不知道支付状态
        // 当定时任务扫描时，先根据orderId，查出wx_no，支付成功，再决定发送
        redisUtil.set("ft:message:payLog:" + type + ":" + orderId, wx_no + "-" + System.currentTimeMillis());
        return resData;
    }

    @Override
    public Map<String, String> wakePay(String prepayId) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        long time = DateUtil.currentSeconds();
        String nonStr = RandomUtil.randomString(20);
        String pack = "prepay_id=" + prepayId;
        String t = "wxb87355b683322bcb\n";
        t += +time + "\n";
        t += nonStr + "\n";
        t += pack + "\n";

        // 签名
        PrivateKey privateKey = WxUtils.getPrivateKey();
        Signature rsa = Signature.getInstance("SHA256withRSA");
        rsa.initSign(privateKey);
        rsa.update(t.getBytes(StandardCharsets.UTF_8));
        byte[] sign = rsa.sign();

        String paySign = Base64.getEncoder().encodeToString(sign);

        HashMap<String, String> payMap = new HashMap<>();
        payMap.put("paySign", paySign);
        payMap.put("timeStamp", String.valueOf(time));
        payMap.put("nonceStr", nonStr);
        payMap.put("package", pack);
        payMap.put("signType", "RSA");
        return payMap;
    }

    @SneakyThrows
    private CloseableHttpClient buildHttpClient() {
        // 自动获取微信证书, 第一次获取证书绕过鉴权
        return getCloseableHttpClient();
    }

    static CloseableHttpClient getCloseableHttpClient() throws NotFoundException, IOException, GeneralSecurityException, HttpCodeException {
        CertificatesManager instance = CertificatesManager.getInstance();
        String merchantId = "1651675178";
        String serialNumber = "5FDB6317341977B747EA9E3C946AA303E565CCF4";
        String apiV3Key = "341977B747EA9E3C946AA303E565CCF4";

        instance.putMerchant(merchantId, new WechatPay2Credentials(merchantId,
                        new PrivateKeySigner(serialNumber, WxUtils.getPrivateKey())),
                apiV3Key.getBytes(StandardCharsets.UTF_8));
        Verifier verifier = instance.getVerifier(merchantId);
        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(merchantId, serialNumber, WxUtils.getPrivateKey())
                .withValidator(new WechatPay2Validator(verifier));
        return builder.build();
    }
}
