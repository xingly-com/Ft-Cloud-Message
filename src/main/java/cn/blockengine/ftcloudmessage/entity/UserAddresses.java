package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
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

    private String userName;

    private String mobile;

    private String province;

    private String city;

    private String area;

    private String address;

    private Long userId;

    private Boolean isDefault;

    private static final long serialVersionUID = 1L;
}