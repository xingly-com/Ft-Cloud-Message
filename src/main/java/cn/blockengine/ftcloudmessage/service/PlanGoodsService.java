package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.request.PlanRequest;
import cn.blockengine.ftcloudmessage.response.PlanGoodsResponse;

import java.util.List;

public interface PlanGoodsService{

    List<PlanGoodsResponse> goodsList(PlanRequest request);

    PlanGoodsResponse goodsDetail(String goodId);

    Boolean add(PlanRequest request);

    Boolean update(PlanRequest request);

    Boolean delete(Long id);
}
