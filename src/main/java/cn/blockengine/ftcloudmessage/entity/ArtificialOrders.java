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
    * 人工传话订单
    */
@ApiModel(description="人工传话订单")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ArtificialOrders extends BaseEntity implements Serializable {
//    @ApiModelProperty(value="")
//    private Long id;
//
//    @ApiModelProperty(value="")
//    private Date createTime;
//
//    @ApiModelProperty(value="")
//    private Date updateTime;
//
//    @ApiModelProperty(value="")
//    private Boolean delete;

    @ApiModelProperty(value="")
    private String socialAccount;

    @ApiModelProperty(value="")
    private Long userId;

    @ApiModelProperty(value="")
    private String content;

    @ApiModelProperty(value="")
    private String appellation;

    @ApiModelProperty(value="")
    private Date sendTime;

    @ApiModelProperty(value="")
    private String remark;

    @ApiModelProperty(value="")
    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}