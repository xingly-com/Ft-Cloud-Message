package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/8 09:57
 */
public class BaseService {

    public String getUserId(HttpServletRequest request){
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("请先登陆");
        }
        return userId;
    }
}
