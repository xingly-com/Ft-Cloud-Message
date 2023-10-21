package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.response.PlanOrderResponse;
import cn.blockengine.ftcloudmessage.service.PlanOrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PlanOrdersServiceImpl extends BaseService implements PlanOrdersService {

    @Resource
    private PlanOrdersMapper planOrdersMapper;

    @Override
    public List<PlanOrderResponse> usPlan(HttpServletRequest request) {
        Long userId = getUserId();
        return planOrdersMapper.selectListByUserId(userId);
    }

    @Override
    public List<PlanOrderResponse> planOrderList(PlanOrderRequest request) {
//        String userId = getUserId(request);
//        return AjaxResult.ok().data("list", planOrdersMapper.selectList(null));
        return planOrdersMapper.selectList(request);
    }

    @Override
    public PlanOrderResponse detail(Long goodId) {
//        String userId = getUserId(request);
        return planOrdersMapper.selectByPrimaryKey(goodId);
    }

    @Override
    public PlanOrderResponse add(PlanOrderRequest orders) {
        Long userId = getUserId();
        orders.setUserId(userId);
        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失
        planOrdersMapper.insertSelective(orders);
        PlanOrderResponse response = new PlanOrderResponse();
        BeanUtils.copyProperties(orders, response);
        return response;
    }

    @Override
    public PlanOrderResponse update(PlanOrderRequest request) {
        //check
        planOrdersMapper.updateByPrimaryKeySelective(request);
        PlanOrderResponse response = new PlanOrderResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }

    @Override
    public Boolean delete(Long id) {
        return planOrdersMapper.deleteByPrimaryKey(id)>0;
    }
}
