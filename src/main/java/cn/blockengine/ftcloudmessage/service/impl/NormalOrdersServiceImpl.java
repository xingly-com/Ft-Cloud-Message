package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.mapper.NormalOrdersMapper;
import cn.blockengine.ftcloudmessage.mapper.UsersMapper;
import cn.blockengine.ftcloudmessage.request.NormalOrderRequest;
import cn.blockengine.ftcloudmessage.response.NormalOrderResponse;
import cn.blockengine.ftcloudmessage.service.NormalOrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NormalOrdersServiceImpl extends BaseService implements NormalOrdersService {

    @Resource
    private NormalOrdersMapper normalOrdersMapper;

    @Resource
    private UsersMapper usersMapper;

    @Override
    public NormalOrderResponse add(NormalOrderRequest orders) {
        Long userId = getUserId();
        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失
        orders.setUserId(userId);
        normalOrdersMapper.insertSelective(orders);
        NormalOrderResponse response = new NormalOrderResponse();
        BeanUtils.copyProperties(orders, response);
        return response;
    }

    @Override
    public NormalOrderResponse update(NormalOrderRequest orders) {
        normalOrdersMapper.updateByPrimaryKeySelective(orders);
        NormalOrderResponse response = new NormalOrderResponse();
        BeanUtils.copyProperties(orders, response);
        return response;
    }

    @Override
    public Boolean delete(Long id) {
        return normalOrdersMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public NormalOrderResponse detail(Long id) {
        return normalOrdersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NormalOrderResponse> normalMessageList(NormalOrderRequest orders) {
        return normalOrdersMapper.selectList(orders);
    }

    @Override
    public List<NormalOrderResponse> usMessage(NormalOrderRequest request) {
        Long userId = getUserId();
        request.setUserId(userId);
        return normalOrdersMapper.selectList(request);
    }

    @Override
    public List<NormalOrderResponse> getMessage(NormalOrderRequest request) {
        Long userId = getUserId();
        Users users = usersMapper.selectById(userId);
        String mobile = users.getMobile();
        request.setMobile(mobile);
        return normalOrdersMapper.selectList(request);
    }
}
