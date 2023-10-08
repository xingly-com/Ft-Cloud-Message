package cn.blockengine.ftcloudmessage.utils;


import cn.blockengine.ftcloudmessage.config.ApplicationContextProvider;
import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.service.impl.ConfigServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/4/2 10:01
 */
public class WechatUtil {

    private static final Logger logger = LoggerFactory.getLogger(WechatUtil.class);

    private final static ConfigServiceImpl configService;

    static {
        configService = ApplicationContextProvider.getBean(ConfigServiceImpl.class);
    }

    public static String[] getOpenId(String code) {
        String appId = configService.getCacheValue("wechat_appid");
        String secret = configService.getCacheValue("wechat_secret");
        logger.info("【小程序获取openId】: code={}, appId={}, secret={}", code, appId, secret);
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                appId, secret, code);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            String r = EntityUtils.toString(entity);
            logger.info("【小程序获取openId】结果:{}", r);
            JSONObject mResult = JSON.parseObject(r);
            String openId = mResult.getString("openid");
            if (StringUtils.isEmpty(openId)) {
                String errorMsg = mResult.getString("errorMsg");
                Integer errorCode = mResult.getInteger("errorCode");
                logger.error("【小程序获取openId】出错，errorMsg:{}, errorCode:{}", errorMsg, errorCode);
                throw new ServiceException(String.format("小程序获取openId出错, errorMsg:%s, errorCode:%d", errorMsg, errorCode));
            }
            String sessionKey = mResult.getString("session_key");
            return new String[]{openId, sessionKey};
        } catch (Exception e) {
            logger.error("【小程序获取openId】出错", e);
            throw new ServiceException("小程序获取openId】出错");
        }
    }

    public static String getPhone(String code) {
        String phone;
        String url = String.format("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=%s",
                getAccessTokenAndRefresh());
        logger.info("【小程序获取手机号】: url={}", url);
        HttpPost httpPost = new HttpPost(url);

        // 把code放到请求体中
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        httpPost.setEntity(new StringEntity(jsonObject.toJSONString(), "UTF-8"));
        logger.info("【小程序获取手机号】: code={}", code);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            HttpEntity entity = response.getEntity();
            String r = EntityUtils.toString(entity);
            logger.info("【小程序获取手机号】结果:{}", r);
            JSONObject mResult = JSON.parseObject(r);
            String phoneNumber = mResult.getJSONObject("phone_info").getString("phoneNumber");
            if (StringUtils.isEmpty(phoneNumber)) {
                String errorMsg = mResult.getString("errorMsg");
                Integer errorCode = mResult.getInteger("errorCode");
                logger.error("【小程序获取手机号】出错，errorMsg:{}, errorCode:{}", errorMsg, errorCode);
                throw new ServiceException("小程序获取手机号出错");
            }
            phone = phoneNumber;
        } catch (Exception e) {
            logger.error("【小程序获取手机号】出错", e);
            throw new ServiceException("小程序获取手机号】出错");
        }
        return phone;
    }

    private static String getAccessTokenAndRefresh() {
        String appId = configService.getCacheValue("wechat_appid");
        String secret = configService.getCacheValue("wechat_secret");
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                appId, secret);
        logger.info("【小程序】获取accessToken url:{}", url);
        String r = HttpClientUtil.doGet(url);
        logger.info("【小程序】获取accessToken结果:{}", r);
        JSONObject json = JSON.parseObject(r);
        assert json != null;
        return json.getString("access_token");
    }
}
