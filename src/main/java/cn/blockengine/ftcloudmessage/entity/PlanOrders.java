package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
    * 计划任务订单表
    */
@ApiModel(description="计划任务订单表")
public class PlanOrders implements Serializable {

    private Long id;


    private Date createTime;


    private Date updateTime;


    private Boolean delete;


    private String planName;


    private Long planGoodsId;


    private Long userId;


    private String mobile;


    private Date sendTime;


    private Long lastDays;


    private Double price;


    private String source;


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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getPlanGoodsId() {
        return planGoodsId;
    }

    public void setPlanGoodsId(Long planGoodsId) {
        this.planGoodsId = planGoodsId;
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

    public Long getLastDays() {
        return lastDays;
    }

    public void setLastDays(Long lastDays) {
        this.lastDays = lastDays;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Long sendFlag) {
        this.sendFlag = sendFlag;
    }
}