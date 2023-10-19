package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
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

    private String avatar;

    private String nikeName;

    private Long sex;

    private String mobile;

    private Long oMark;

    private String openId;

    private static final long serialVersionUID = 1L;
}