package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.NormalOrderRequest;
import cn.blockengine.ftcloudmessage.response.NormalOrderResponse;

import java.util.List;

public interface NormalOrdersService {
    Boolean add(NormalOrderRequest orders);

    Boolean update(NormalOrderRequest orders);

    Boolean delete(Long id);

    NormalOrderResponse detail(Long id);

    List<NormalOrderResponse> normalMessageList(NormalOrderRequest orders);

    List<NormalOrderResponse> getMessage(NormalOrderRequest orders);

    List<NormalOrderResponse> usMessage(NormalOrderRequest request);
}
