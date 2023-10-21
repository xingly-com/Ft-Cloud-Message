package cn.blockengine.ftcloudmessage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户地址id")
    private Long userAddressId;

//    @ApiModelProperty(value = "收件人姓名")
    private String envelope;

//    @ApiModelProperty(value = "收件人手机号")
    private String stationery;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    @ApiModelProperty(value = "是否发送")
    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}