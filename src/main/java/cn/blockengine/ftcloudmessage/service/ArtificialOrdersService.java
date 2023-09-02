package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.mapper.ArtificialOrdersMapper;

public interface ArtificialOrdersService{


    AjaxResult add(HttpServletRequest request, ArtificialOrders orders);
}
