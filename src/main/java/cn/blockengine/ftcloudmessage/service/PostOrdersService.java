package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.PostOrderRequest;
import cn.blockengine.ftcloudmessage.response.PostOrderResponse;

import java.util.List;

public interface PostOrdersService{

    Boolean add(PostOrderRequest orders);

    Boolean update(PostOrderRequest orders);

    Boolean delete(Long id);

    PostOrderResponse detail(Long id);

    List<PostOrderResponse> list(PostOrderRequest orders);

    List<PostOrderResponse> usPost(PostOrderRequest request);
}
