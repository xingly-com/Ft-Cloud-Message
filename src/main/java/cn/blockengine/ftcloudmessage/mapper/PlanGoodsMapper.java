package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.PlanGoods;
import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.request.PlanRequest;
import cn.blockengine.ftcloudmessage.response.PlanGoodsResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlanGoodsMapper extends BaseMapper<PlanGoodsMapper> {

    List<PlanGoodsResponse> goodsList(@Param("plan") PlanRequest request);

    int deleteByPrimaryKey(Long id);

    int insertSelective(PlanGoods record);

    PlanGoodsResponse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlanGoods record);
}