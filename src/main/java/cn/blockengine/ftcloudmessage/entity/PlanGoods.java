package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
    * 计划任务商品表
    */
@ApiModel(description="计划任务商品表")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class PlanGoods extends BaseEntity  implements Serializable {

//    private Long id;
//
//    private Date createTime;
//
//    private Date updateTime;
//
//    private Boolean delete;

    private String title;

    private String description;

    private String tip;

    private String price;

    private static final long serialVersionUID = 1L;
}