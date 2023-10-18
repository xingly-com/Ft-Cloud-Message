package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.request.UserRequest;
import cn.blockengine.ftcloudmessage.response.UserResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UsersService{

    UserResponse us(HttpServletRequest request);

    UserResponse loginUser(UserRequest request);

    UserResponse openIdLogin(UserRequest request);

    String getPhone(UserRequest request);
}
