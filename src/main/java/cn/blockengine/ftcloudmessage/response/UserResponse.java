package cn.blockengine.ftcloudmessage.response;


import cn.blockengine.ftcloudmessage.entity.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/3/31 21:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserResponse extends Users {

    private String token;
}
