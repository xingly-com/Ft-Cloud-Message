package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.component.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.mapper.UsersMapper;

public interface UsersService{

    AjaxResult login(Users user);

    AjaxResult usMessage(HttpServletRequest request, PageInfo pageInfo);

    AjaxResult us(HttpServletRequest request);

    AjaxResult getMessage(HttpServletRequest request, PageInfo pageInfo);


    AjaxResult usPlan(HttpServletRequest request, PageInfo pageInfo);

    AjaxResult usArtificial(HttpServletRequest request, PageInfo pageInfo);

    AjaxResult usPost(HttpServletRequest request, PageInfo pageInfo);

    AjaxResult usAddress(HttpServletRequest request, PageInfo pageInfo);
}
