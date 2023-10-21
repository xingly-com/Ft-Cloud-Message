package cn.blockengine.ftcloudmessage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
    * 计划任务订单表
    */
@ApiModel(description="计划任务订单表")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class PlanOrders extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "计划名称")
    private String planName;

    @ApiModelProperty(value = "计划商品id")
    private Long planGoodsId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户手机")
    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发送时间")
    private Date sendTime;

//    @ApiModelProperty(value = "发送次数")
    private Long lastDays;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "是否发送")
    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}