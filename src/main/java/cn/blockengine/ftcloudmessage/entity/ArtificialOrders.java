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
    * 人工传话订单
    */
@ApiModel(description="人工传话订单")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ArtificialOrders extends BaseEntity implements Serializable {

//    @ApiModelProperty(value="")
    private String socialAccount;

    @ApiModelProperty(value="用户id")
    private Long userId;

    @ApiModelProperty(value="内容")
    private String content;

//    @ApiModelProperty(value="")
    private String appellation;

    @ApiModelProperty(value="发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="是否发送")
    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}