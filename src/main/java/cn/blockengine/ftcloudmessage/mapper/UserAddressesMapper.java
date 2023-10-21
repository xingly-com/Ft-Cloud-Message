package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.UserAddresses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddressesMapper extends BaseMapper<UserAddresses> {
    List<UserAddresses> selectListByUserId(Long userId);

    int insertSelective(UserAddresses record);

    UserAddresses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddresses record);

    int deleteAddressById(@Param("id")Long id);

    List<UserAddresses> selectAddressesByUserId(@Param("userId")Long userId);

    int updateDefaultAddressById(@Param("id")Long id);

    int updateNoDefaultAddressByIds(@Param("ids")List<Long> ids);
}