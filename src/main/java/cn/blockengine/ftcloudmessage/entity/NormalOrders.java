package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
    * 普通短信订单表
    */
@ApiModel(description="普通短信订单表")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getPublic() {
        return open;
    }

    public void setPublic(Boolean open) {
        this.open = open;
    }

    public Long getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Long sendFlag) {
        this.sendFlag = sendFlag;
    }
}