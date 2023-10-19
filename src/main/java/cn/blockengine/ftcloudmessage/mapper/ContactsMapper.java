package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.request.ContactsRequest;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.response.ContactsResponse;
import cn.blockengine.ftcloudmessage.response.PlanOrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:49
 */
@Mapper
public interface ContactsMapper {

    List<ContactsResponse> selectList(@Param("contacts") ContactsRequest contacts);

    ContactsResponse selectByPrimaryKey(Long id);

    int insertSelective(ContactsRequest contacts);

    int updateByPrimaryKeySelective(ContactsRequest contacts);

    int deleteByPrimaryKey(Long id);
}
