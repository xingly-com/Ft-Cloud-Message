package cn.blockengine.ftcloudmessage.service;

import cn.blockengine.ftcloudmessage.entity.*;
import cn.blockengine.ftcloudmessage.request.UserRequest;
import cn.blockengine.ftcloudmessage.response.UserResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UsersService{

    List<NormalOrders> usMessage(HttpServletRequest request);

    UserResponse us(HttpServletRequest request);

    List<NormalOrders> getMessage(HttpServletRequest request);

    List<ArtificialOrders> usArtificial(HttpServletRequest request);

    List<PostOrders> usPost(HttpServletRequest request);

    UserResponse loginUser(UserRequest request);

    UserResponse openIdLogin(UserRequest request);

    String getPhone(UserRequest request);
}
