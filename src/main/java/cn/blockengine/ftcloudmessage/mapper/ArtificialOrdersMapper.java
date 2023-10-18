package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.request.ArtificialOrderRequest;
import cn.blockengine.ftcloudmessage.response.ArtificialOrderResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArtificialOrdersMapper extends BaseMapper<ArtificialOrders> {

    List<ArtificialOrderResponse> selectList(@Param("request")ArtificialOrderRequest request);

    ArtificialOrderResponse selectByPrimaryKey(@Param("id")Long id);

    int deleteByPrimaryKey(@Param("id")Long id);

    int insertSelective(ArtificialOrderRequest request);

    int updateByPrimaryKeySelective(ArtificialOrderRequest request);
}