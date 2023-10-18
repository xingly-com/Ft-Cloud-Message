package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostOrdersMapper extends BaseMapper<PostOrders> {

    List<PostOrders> selectListByUserId(Long userId);
}