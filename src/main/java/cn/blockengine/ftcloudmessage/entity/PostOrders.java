package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
    * 邮寄订单表
    */
@ApiModel(description="邮寄订单表")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class PostOrders extends BaseEntity implements Serializable {

    private Long userId;

    private Long userAddressId;

    private String envelope;

    private String stationery;

    private String content;

    private Date sendTime;

    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}