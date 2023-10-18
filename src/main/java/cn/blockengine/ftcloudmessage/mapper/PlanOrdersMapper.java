package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.response.PlanOrderResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlanOrdersMapper extends BaseMapper<PlanOrders> {

    List<PlanOrderResponse> selectListByUserId(Long userId);

    List<PlanOrderResponse> selectList(@Param("plan") PlanOrderRequest request);

    PlanOrderResponse selectByPrimaryKey(Long id);

    int insertSelective(PlanOrderRequest planOrders);

    int updateByPrimaryKeySelective(PlanOrderRequest planOrders);

    int deleteByPrimaryKey(Long id);

}