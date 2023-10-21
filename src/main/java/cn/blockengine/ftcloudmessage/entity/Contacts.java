package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:45
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Contacts extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户id")
    private Long userId;
}
