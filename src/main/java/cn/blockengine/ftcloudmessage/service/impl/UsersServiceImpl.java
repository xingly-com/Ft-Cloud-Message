package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.mapper.UsersMapper;
import cn.blockengine.ftcloudmessage.request.UserRequest;
import cn.blockengine.ftcloudmessage.response.UserResponse;
import cn.blockengine.ftcloudmessage.service.UsersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import cn.blockengine.ftcloudmessage.utils.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UsersServiceImpl extends BaseService implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    @Transactional
    public UserResponse loginUser(UserRequest request) {
        if (StringUtils.isEmpty(request.getCode())) {
            throw new ServiceException("code不能为空");
        }
        String[] codeArray = WechatUtil.getOpenId(request.getCode());
        String openId = codeArray[0];

        String phone = request.getMobile();

        if (StringUtils.isEmpty(phone)) {
            throw new ServiceException("手机号不能为空");
        }

        //根据手机号和openId查询用户 唯一
        Users user = usersMapper.getUserByOpenId(openId);

        if (user == null) {
            //register
            user = new Users();
            BeanUtils.copyProperties(request, user);
            user.setOpenId(openId);
            user.setMobile(phone);
            //默认头像
            user.setAvatar("https://ft-water.oss-cn-nanjing.aliyuncs.com/default/87b8823e-b753-4d35-b9c9-cd81aa6d779e.jpg");
            //随机昵称-中文
            user.setNikeName(UUID.randomUUID().toString().split("-")[0]);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

//            insertUser(user);
            usersMapper.insert(user);
        }

        if (!user.getMobile().equals(phone)) {
            throw new ServiceException("该微信号已经和其它手机号关联吧");
        }

        return getUserResponse(user);
    }

    @Override
    public UserResponse openIdLogin(UserRequest request) {
        if (StringUtils.isEmpty(request.getOpenId())) {
            throw new ServiceException("openId不能为空");
        }
        String openId = request.getOpenId();
        //根据手机号和openId查询用户 唯一
        Users user = usersMapper.getUserByOpenId(openId);
        if (user == null) {
            throw new ServiceException("该微信号还未注册");
        }
        return getUserResponse(user);
    }


    @Override
    public String getPhone(UserRequest request) {
//        log.info("getPhone code:{}", request.getCode());
        return WechatUtil.getPhone(request.getCode());
    }

    @Override
    public UserResponse us(HttpServletRequest request) {
        Long userId = getUserId();
        return usersMapper.getUserByUserId(userId);
    }

    private UserResponse getUserResponse(Users user) {
        String token = JwtUtils.getJwtToken(user.getId().toString());
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        userResponse.setToken(token);
        return userResponse;
    }
}
