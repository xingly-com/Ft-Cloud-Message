package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.entity.NormalOrders;

import javax.servlet.http.HttpServletRequest;

public interface NormalOrdersService{

    Boolean add(HttpServletRequest request, NormalOrders orders);
}
