package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanOrdersMapper extends BaseMapper<PlanOrders> {

    List<PlanOrders> selectListByUserId(String userId);
}