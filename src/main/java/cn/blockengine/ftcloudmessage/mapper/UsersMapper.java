package cn.blockengine.ftcloudmessage.mapper;

import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.response.UserResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    Users getUserByOpenId(String openId);

    UserResponse getUserByUserId(String userId);
}