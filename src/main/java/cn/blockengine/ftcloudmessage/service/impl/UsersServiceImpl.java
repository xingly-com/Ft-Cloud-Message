package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.*;
import cn.blockengine.ftcloudmessage.exception.ServiceException;
import cn.blockengine.ftcloudmessage.mapper.*;
import cn.blockengine.ftcloudmessage.request.UserRequest;
import cn.blockengine.ftcloudmessage.response.UserResponse;
import cn.blockengine.ftcloudmessage.service.UsersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import cn.blockengine.ftcloudmessage.utils.WechatUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl extends BaseService implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private NormalOrdersMapper normalOrdersMapper;

    @Resource
    private PlanOrdersMapper planOrdersMapper;

    @Resource
    private ArtificialOrdersMapper artificialOrdersMapper;

    @Resource
    private PostOrdersMapper postOrdersMapper;

    @Resource
    private UserAddressesMapper userAddressesMapper;

//    @Override
//    public AjaxResult login(Users user) {
//
//        String mobile = user.getMobile();
//        if (StringUtils.isEmpty(mobile)) {
//            AjaxResult.error().message("手机号不能为空");
//        }
//
//        Users users = usersMapper.selectOne(new LambdaQueryWrapper<Users>().eq(Users::getMobile, mobile));
//        if (!Optional.ofNullable(users).isPresent()) {
//            usersMapper.insert(user);
//        }
//
//        String jwtToken = JwtUtils.getJwtToken(user.getId().toString());
//        return AjaxResult.ok().data("token", jwtToken).data("userInfo", user);
//    }


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
            user.setCreateTime(new Date());

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
    public List<NormalOrders> usMessage(HttpServletRequest request) {
        String userId = getUserId(request);
        return normalOrdersMapper.selectListByUserId(userId);
    }

    @Override
    public UserResponse us(HttpServletRequest request) {
        String userId = getUserId(request);
        return usersMapper.getUserByUserId(userId);
    }

    @Override
    public List<NormalOrders> getMessage(HttpServletRequest request) {
        String userId = getUserId(request);

        Users users = usersMapper.selectById(userId);
        String mobile = users.getMobile();

//        IPage<NormalOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
//        normalOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<NormalOrders>().eq(NormalOrders::getMobile, mobile));
//        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
        return normalOrdersMapper.selectListByMobile(mobile);
    }

    @Override
    public List<PlanOrders> usPlan(HttpServletRequest request) {
        String userId = getUserId(request);
        return planOrdersMapper.selectListByUserId(userId);
    }

    @Override
    public List<ArtificialOrders> usArtificial(HttpServletRequest request) {
        String userId = getUserId(request);
        return artificialOrdersMapper.selectListByUserId(userId);
    }

    @Override
    public List<PostOrders> usPost(HttpServletRequest request) {
        String userId = getUserId(request);
        return postOrdersMapper.selectListByUserId(userId);
    }

    @Override
    public List<UserAddresses> usAddress(HttpServletRequest request) {
        String userId = getUserId(request);
        return userAddressesMapper.selectListByUserId(userId);
    }


    private UserResponse getUserResponse(Users user) {
//        Users users = new Users();
//        users.setUser(user);
//        users.setId(user.getUserId());
        String token = JwtUtils.getJwtToken(user.getId().toString());
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        userResponse.setToken(token);
        return userResponse;
    }
}
