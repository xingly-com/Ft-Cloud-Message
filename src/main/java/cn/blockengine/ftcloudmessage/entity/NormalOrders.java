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
    * 普通短信订单表
    */
@ApiModel(description="普通短信订单表")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class NormalOrders extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "短信内容")
    private String messageContent;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户地址id")
    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发送时间")
    private Date sendTime;

    @ApiModelProperty(value = "是否开启")
    private Boolean open;

    @ApiModelProperty(value = "是否发送")
    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}