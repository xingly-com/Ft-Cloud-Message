package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtificialOrdersMapper extends BaseMapper<ArtificialOrders> {
    List<ArtificialOrders> selectListByUserId(Long userId);
}