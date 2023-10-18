package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.request.PostOrderRequest;
import cn.blockengine.ftcloudmessage.response.PostOrderResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostOrdersMapper extends BaseMapper<PostOrders> {

    List<PostOrderResponse> selectList(@Param("request") PostOrderRequest request);

    PostOrderResponse selectByPrimaryKey(@Param("id")Long id);

    int deleteByPrimaryKey(@Param("id")Long id);

    int insertSelective(PostOrderRequest request);

    int updateByPrimaryKeySelective(PostOrderRequest request);
}