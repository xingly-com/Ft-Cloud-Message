package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.mapper.ArtificialOrdersMapper;
import cn.blockengine.ftcloudmessage.mapper.PostOrdersMapper;
import cn.blockengine.ftcloudmessage.service.PostOrdersService;
import cn.blockengine.ftcloudmessage.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class PostOrdersServiceImpl implements PostOrdersService {
    @Resource
    private PostOrdersMapper postOrdersMapper;
    @Override
    public AjaxResult add(HttpServletRequest request, PostOrders orders) {
        String userId = JwtUtils.getUserIdByJwt(request);
        if (StringUtils.isEmpty(userId)) {
            return AjaxResult.noAuth();
        }

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        postOrdersMapper.insert(orders);
        return AjaxResult.ok();
    }
}
