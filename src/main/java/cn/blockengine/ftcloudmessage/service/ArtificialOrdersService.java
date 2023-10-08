package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;

import javax.servlet.http.HttpServletRequest;

public interface ArtificialOrdersService{

    Boolean add(HttpServletRequest request, ArtificialOrders orders);
}
