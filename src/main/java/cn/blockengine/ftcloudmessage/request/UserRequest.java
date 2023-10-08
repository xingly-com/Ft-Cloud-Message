package cn.blockengine.ftcloudmessage.request;

import cn.blockengine.ftcloudmessage.entity.Users;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Desc
 * @Author 方糖
 * @Date 2023-04-01 15:11
 **/
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserRequest extends Users {

    @ApiModelProperty(value = "新密码")
    private String newPassword;

    @ApiModelProperty(value = "验证码")
    private String code;
}
