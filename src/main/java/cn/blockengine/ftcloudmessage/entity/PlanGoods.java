package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

//    @ApiModelProperty(value = "图片")
    private String tip;

    @ApiModelProperty(value = "价格")
    private String price;

    private static final long serialVersionUID = 1L;
}