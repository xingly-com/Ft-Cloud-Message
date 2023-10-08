package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalOrdersMapper extends BaseMapper<NormalOrders> {

    List<NormalOrders> selectListByUserId(String userId);

    List<NormalOrders> selectListByMobile(String mobile);
}