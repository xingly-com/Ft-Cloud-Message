package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.mapper.PostOrdersMapper;
import cn.blockengine.ftcloudmessage.request.PostOrderRequest;
import cn.blockengine.ftcloudmessage.response.PostOrderResponse;
import cn.blockengine.ftcloudmessage.service.PostOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostOrdersServiceImpl extends BaseService implements PostOrdersService {
    @Resource
    private PostOrdersMapper postOrdersMapper;

    @Override
    public Boolean add(PostOrderRequest orders) {
        Long userId = getUserId();

        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失
        orders.setUserId(userId);
        return postOrdersMapper.insert(orders) > 0;
    }

    @Override
    public Boolean update(PostOrderRequest orders) {
        return postOrdersMapper.updateByPrimaryKeySelective(orders) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return postOrdersMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public PostOrderResponse detail(Long id) {
        return postOrdersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PostOrderResponse> list(PostOrderRequest orders) {
        return postOrdersMapper.selectList(orders);
    }

    @Override
    public List<PostOrderResponse> usPost(PostOrderRequest request) {
        request.setUserId(getUserId());
        return postOrdersMapper.selectList(request);
    }
}
