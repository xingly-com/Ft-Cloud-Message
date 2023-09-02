package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.mapper.NormalOrdersMapper;

public interface NormalOrdersService{


    AjaxResult add(HttpServletRequest request, NormalOrders orders);
}
