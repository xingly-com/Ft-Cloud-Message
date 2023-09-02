package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.mapper.PlanOrdersMapper;
import cn.blockengine.ftcloudmessage.service.PlanOrdersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class PlanOrdersServiceImpl implements PlanOrdersService {

    @Resource
    private PlanOrdersMapper planOrdersMapper;

    @Override
    public AjaxResult getGoodsList(HttpServletRequest request) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        return AjaxResult.ok().data("list", planOrdersMapper.selectList(null));
    }

    @Override
    public AjaxResult getGoodsDetail(HttpServletRequest request, String goodId) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        return AjaxResult.ok().data("detail", planOrdersMapper.selectById(goodId));
    }

    @Override
    public AjaxResult add(HttpServletRequest request, PlanOrders orders) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        planOrdersMapper.insert(orders);
        return AjaxResult.ok();
    }
}
