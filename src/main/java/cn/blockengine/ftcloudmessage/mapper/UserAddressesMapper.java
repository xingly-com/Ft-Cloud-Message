package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.UserAddresses;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddressesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddresses record);

    int insertSelective(UserAddresses record);

    UserAddresses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddresses record);

    int updateByPrimaryKey(UserAddresses record);
}