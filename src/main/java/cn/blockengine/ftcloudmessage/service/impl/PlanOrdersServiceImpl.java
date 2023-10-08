package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.service.PlanOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PlanOrdersServiceImpl extends BaseService implements PlanOrdersService {

    @Resource
    private PlanOrdersMapper planOrdersMapper;

    @Override
    public List<PlanOrders> goodsList(HttpServletRequest request) {
//        String userId = getUserId(request);

//        return AjaxResult.ok().data("list", planOrdersMapper.selectList(null));
        return planOrdersMapper.selectList(null);
    }

    @Override
    public PlanOrders goodsDetail(HttpServletRequest request, String goodId) {
//        String userId = getUserId(request);

        return planOrdersMapper.selectById(goodId);
    }

    @Override
    public Boolean add(HttpServletRequest request, PlanOrders orders) {
        String userId = getUserId(request);

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        return planOrdersMapper.insert(orders)>0;
//        return AjaxResult.ok();
    }
}
