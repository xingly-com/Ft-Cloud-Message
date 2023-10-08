package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.UserAddresses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressesMapper extends BaseMapper<UserAddresses> {
    List<UserAddresses> selectListByUserId(String userId);
}