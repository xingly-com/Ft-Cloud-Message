package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
    * 用户表
    */
@ApiModel(description="用户表")
@Data
@ToString
public class Users implements Serializable {

//    @TableId(type = IdType.INPUT)
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Boolean delete;

    private String avatar;

    private String nikeName;

    private Long sex;

    private String mobile;

    private Long oMark;

    private String openId;

    private static final long serialVersionUID = 1L;
}