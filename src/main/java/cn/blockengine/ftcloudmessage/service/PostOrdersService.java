package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.mapper.PostOrdersMapper;

public interface PostOrdersService{


    AjaxResult add(HttpServletRequest request, PostOrders orders);
}
