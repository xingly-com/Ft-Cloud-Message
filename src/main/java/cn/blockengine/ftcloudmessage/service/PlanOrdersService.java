package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;

public interface PlanOrdersService{

    AjaxResult getGoodsList(HttpServletRequest request);

    AjaxResult getGoodsDetail(HttpServletRequest request, String goodId);

    AjaxResult add(HttpServletRequest request, PlanOrders orders);
}
