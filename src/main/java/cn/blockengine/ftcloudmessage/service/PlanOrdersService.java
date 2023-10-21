package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.response.PlanOrderResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;

import java.util.List;

public interface PlanOrdersService{

    List<PlanOrderResponse> usPlan(HttpServletRequest request);

    List<PlanOrderResponse> planOrderList(PlanOrderRequest request);

    PlanOrderResponse detail(Long goodId);

    PlanOrderResponse add(PlanOrderRequest orders);

    PlanOrderResponse update(PlanOrderRequest request);

    Boolean delete(Long id);
}
