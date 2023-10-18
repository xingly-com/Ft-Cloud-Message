package cn.blockengine.ftcloudmessage.service.impl;

import cn.blockengine.ftcloudmessage.mapper.PlanGoodsMapper;
import cn.blockengine.ftcloudmessage.request.PlanRequest;
import cn.blockengine.ftcloudmessage.response.PlanGoodsResponse;
import cn.blockengine.ftcloudmessage.service.PlanGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PlanGoodsServiceImpl implements PlanGoodsService {

    @Resource
    private PlanGoodsMapper goodsMapper;


    @Override
    public List<PlanGoodsResponse> goodsList(PlanRequest request) {
        return goodsMapper.goodsList(request);
    }

    @Override
    public PlanGoodsResponse goodsDetail(String goodId) {
        return goodsMapper.selectByPrimaryKey(Long.valueOf(goodId));
    }

    @Override
    public Boolean add(PlanRequest request) {
        return goodsMapper.insertSelective(request) > 0;
    }

    @Override
    public Boolean update(PlanRequest request) {
        return goodsMapper.updateByPrimaryKeySelective(request) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return goodsMapper.deleteByPrimaryKey(id) > 0;
    }
}
