package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;

import java.util.List;

public interface PlanOrdersService{

    List<PlanOrders> goodsList(HttpServletRequest request);

    PlanOrders goodsDetail(HttpServletRequest request, String goodId);

    Boolean add(HttpServletRequest request, PlanOrders orders);
}
