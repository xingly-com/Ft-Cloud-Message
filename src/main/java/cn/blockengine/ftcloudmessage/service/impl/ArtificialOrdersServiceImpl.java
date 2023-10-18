package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.mapper.ArtificialOrdersMapper;
import cn.blockengine.ftcloudmessage.request.ArtificialOrderRequest;
import cn.blockengine.ftcloudmessage.response.ArtificialOrderResponse;
import cn.blockengine.ftcloudmessage.service.ArtificialOrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArtificialOrdersServiceImpl extends BaseService implements ArtificialOrdersService {

    @Resource
    private ArtificialOrdersMapper artificialOrdersMapper;

    @Override
    public Boolean add(ArtificialOrderRequest orders) {
        Long userId = getUserId();
        orders.setUserId(userId);
        // todo 这里需要判断用户是否支付, 不然被抓包后, 可以直接调用接口, 造成损失
        return artificialOrdersMapper.insert(orders) > 0;
    }

    @Override
    public Boolean update(ArtificialOrderRequest orders) {
        return artificialOrdersMapper.updateByPrimaryKeySelective(orders) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return artificialOrdersMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public ArtificialOrderResponse detail(Long id) {
        return artificialOrdersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ArtificialOrderResponse> list(ArtificialOrderRequest orders) {
        return artificialOrdersMapper.selectList(orders);
    }

    @Override
    public List<ArtificialOrderResponse> usArtificial(ArtificialOrderRequest request) {
        Long userId = getUserId();
        request.setUserId(userId);
        return artificialOrdersMapper.selectList(request);
    }
}
