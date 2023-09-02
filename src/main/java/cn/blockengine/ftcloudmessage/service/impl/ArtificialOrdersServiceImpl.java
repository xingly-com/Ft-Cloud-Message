package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.mapper.ArtificialOrdersMapper;
import cn.blockengine.ftcloudmessage.service.ArtificialOrdersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class ArtificialOrdersServiceImpl implements ArtificialOrdersService {

    @Resource
    private ArtificialOrdersMapper artificialOrdersMapper;
    @Override
    public AjaxResult add(HttpServletRequest request, ArtificialOrders orders) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        artificialOrdersMapper.insert(orders);
        return AjaxResult.ok();
    }
}
