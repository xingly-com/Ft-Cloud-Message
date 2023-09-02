package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.component.PageInfo;
import cn.blockengine.ftcloudmessage.entity.*;
import cn.blockengine.ftcloudmessage.mapper.*;
import cn.blockengine.ftcloudmessage.service.UsersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

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

    @Override
    public AjaxResult login(Users user) {

        String mobile = user.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            AjaxResult.error().message("手机号不能为空");
        }

        Users users = usersMapper.selectOne(new LambdaQueryWrapper<Users>().eq(Users::getMobile, mobile));
        if (!Optional.ofNullable(users).isPresent()) {
            usersMapper.insert(user);
        }

        String jwtToken = JwtUtils.getJwtToken(user.getId().toString());
        return AjaxResult.ok().data("token", jwtToken).data("userInfo", user);
    }

    @Override
    public AjaxResult usMessage(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        IPage<NormalOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        normalOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<NormalOrders>().eq(NormalOrders::getUserId, userId));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }

    @Override
    public AjaxResult us(HttpServletRequest request) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }
        return AjaxResult.ok().data("userInfo", usersMapper.selectById(userId));
    }

    @Override
    public AjaxResult getMessage(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        Users users = usersMapper.selectById(userId);
        String mobile = users.getMobile();

        IPage<NormalOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        normalOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<NormalOrders>().eq(NormalOrders::getMobile, mobile));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }

    @Override
    public AjaxResult usPlan(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        IPage<PlanOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        planOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<PlanOrders>().eq(PlanOrders::getUserId, userId));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }

    @Override
    public AjaxResult usArtificial(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        IPage<ArtificialOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        artificialOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<ArtificialOrders>().eq(ArtificialOrders::getUserId, userId));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }

    @Override
    public AjaxResult usPost(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        IPage<PostOrders> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        postOrdersMapper.selectPage(iPage, new LambdaQueryWrapper<PostOrders>().eq(PostOrders::getUserId, userId));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }

    @Override
    public AjaxResult usAddress(HttpServletRequest request, PageInfo pageInfo) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        IPage<UserAddresses> iPage = new Page<>(pageInfo.getPageSize(), pageInfo.getPageNum());
        userAddressesMapper.selectPage(iPage, new LambdaQueryWrapper<UserAddresses>().eq(UserAddresses::getUserId, userId));
        return AjaxResult.ok().data("list", iPage.getRecords()).data("total", iPage.getTotal()).data("current", iPage.getCurrent());
    }
}
