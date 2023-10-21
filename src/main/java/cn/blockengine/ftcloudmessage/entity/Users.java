package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
    * 用户表
    */
@ApiModel(description="用户表")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Users extends BaseEntity  implements Serializable {

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nikeName;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private Long oMark;

    @ApiModelProperty(value = "微信openId")
    private String openId;

    private static final long serialVersionUID = 1L;
}