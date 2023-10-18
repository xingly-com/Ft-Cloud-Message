package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/8 09:57
 */
public class BaseService {

    public Long getUserId(){
        String userId = JwtUtils.getUserIdByJwt(getContextRequest());
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("请先登陆",401);
        }
        return Long.valueOf(userId);
    }

    private HttpServletRequest getContextRequest() {
        return contextRequest;
    }

    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest contextRequest;

    {
        assert requestAttributes != null;
        contextRequest = requestAttributes.getRequest();
    }
}
