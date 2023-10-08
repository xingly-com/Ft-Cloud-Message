package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.mapper.NormalOrdersMapper;
import cn.blockengine.ftcloudmessage.service.NormalOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class NormalOrdersServiceImpl extends BaseService implements NormalOrdersService {

    @Resource
    private NormalOrdersMapper normalOrdersMapper;

    @Override
    public Boolean add(HttpServletRequest request, NormalOrders orders) {
//        String userId = getUserId(request);

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        return normalOrdersMapper.insert(orders) > 0;
//        return AjaxResult.ok();
    }
}
