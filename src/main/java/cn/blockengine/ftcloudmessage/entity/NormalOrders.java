package cn.blockengine.ftcloudmessage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
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

    private String messageContent;

    private Long userId;

    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    private Boolean open;

    private Long sendFlag;

    private static final long serialVersionUID = 1L;
}