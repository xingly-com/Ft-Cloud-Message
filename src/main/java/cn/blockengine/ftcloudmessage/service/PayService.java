package cn.blockengine.ftcloudmessage.service;

import com.alibaba.fastjson2.JSONObject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public interface PayService {
    JSONObject createPay(Long orderId, String price, String type);

    Map<String, String> wakePay(String prepayId) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException;
}
