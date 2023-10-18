package cn.blockengine.ftcloudmessage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
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

//    private Long id;
//
//    private Date createTime;
//
//
//    private Date updateTime;
//
//
//    private Boolean delete;


    private String planName;

    private Long planGoodsId;

    private Long userId;

    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    private Long lastDays;

    private Double price;

    private String source;

    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}