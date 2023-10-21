package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
    * 用户地址表
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(description="用户地址表")
@Data
@ToString
public class UserAddresses extends BaseEntity  implements Serializable {

    @ApiModelProperty(value = "收件人姓名")
    private String userName;

    @ApiModelProperty(value = "收件人手机号")
    private String mobile;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "是否默认地址")
    private Boolean isDefault;

    private static final long serialVersionUID = 1L;
}