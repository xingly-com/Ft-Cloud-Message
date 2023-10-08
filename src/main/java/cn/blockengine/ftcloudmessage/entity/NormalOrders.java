package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
    * 普通短信订单表
    */
@ApiModel(description="普通短信订单表")
@Data
@ToString
public class NormalOrders implements Serializable {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Boolean delete;

    private String messageContent;

    private Long userId;

    private String mobile;

    private Date sendTime;

    private Boolean open;

    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}