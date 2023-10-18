package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.request.NormalOrderRequest;
import cn.blockengine.ftcloudmessage.response.NormalOrderResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NormalOrdersMapper extends BaseMapper<NormalOrders> {

    List<NormalOrderResponse> selectList(@Param("request") NormalOrderRequest request);

    int updateByPrimaryKeySelective(NormalOrderRequest request);

    int insertSelective(NormalOrderRequest request);

    int deleteByPrimaryKey(Long id);

    NormalOrderResponse selectByPrimaryKey(Long id);
}