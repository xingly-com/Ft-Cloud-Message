package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.mapper.PostOrdersMapper;
import cn.blockengine.ftcloudmessage.service.PostOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class PostOrdersServiceImpl extends BaseService implements PostOrdersService {
    @Resource
    private PostOrdersMapper postOrdersMapper;

    @Override
    public Boolean add(HttpServletRequest request, PostOrders orders) {
        String userId = getUserId(request);

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失

        return postOrdersMapper.insert(orders) > 0;
    }
}
