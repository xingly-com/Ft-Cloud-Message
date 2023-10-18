package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.ArtificialOrderRequest;
import cn.blockengine.ftcloudmessage.response.ArtificialOrderResponse;

import java.util.List;

public interface ArtificialOrdersService{

    Boolean add(ArtificialOrderRequest orders);

    Boolean update(ArtificialOrderRequest orders);

    Boolean delete(Long id);

    ArtificialOrderResponse detail(Long id);

    List<ArtificialOrderResponse> list(ArtificialOrderRequest orders);

    List<ArtificialOrderResponse> usArtificial(ArtificialOrderRequest orders);
}
