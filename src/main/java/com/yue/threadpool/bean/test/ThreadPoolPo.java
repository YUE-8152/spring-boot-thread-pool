package com.yue.threadpool.bean.test;

import java.io.Serializable;

public class ThreadPoolPo implements Serializable {
    private static final long serialVersionUID = -8039743429564096968L;
    private Integer id;

    private String merCode;

    private String childMerCode;

    private String levelName;

    private String cardDeposit;

    private String serviceFee;

    private Integer dayLimitTimes;

    private String dayLimitAmount;

    private Integer monthLimitTimes;

    private String monthLimitAmount;

    private Integer openType;

    private Integer status;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerCode() {
        return merCode;
    }

    public void setMerCode(String merCode) {
        this.merCode = merCode;
    }

    public String getChildMerCode() {
        return childMerCode;
    }

    public void setChildMerCode(String childMerCode) {
        this.childMerCode = childMerCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getCardDeposit() {
        return cardDeposit;
    }

    public void setCardDeposit(String cardDeposit) {
        this.cardDeposit = cardDeposit;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getDayLimitTimes() {
        return dayLimitTimes;
    }

    public void setDayLimitTimes(Integer dayLimitTimes) {
        this.dayLimitTimes = dayLimitTimes;
    }

    public String getDayLimitAmount() {
        return dayLimitAmount;
    }

    public void setDayLimitAmount(String dayLimitAmount) {
        this.dayLimitAmount = dayLimitAmount;
    }

    public Integer getMonthLimitTimes() {
        return monthLimitTimes;
    }

    public void setMonthLimitTimes(Integer monthLimitTimes) {
        this.monthLimitTimes = monthLimitTimes;
    }

    public String getMonthLimitAmount() {
        return monthLimitAmount;
    }

    public void setMonthLimitAmount(String monthLimitAmount) {
        this.monthLimitAmount = monthLimitAmount;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "DhMemberLevelPo{" +
                "id=" + id +
                ", merCode='" + merCode + '\'' +
                ", childMerCode='" + childMerCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", cardDeposit='" + cardDeposit + '\'' +
                ", serviceFee='" + serviceFee + '\'' +
                ", dayLimitTimes=" + dayLimitTimes +
                ", dayLimitAmount='" + dayLimitAmount + '\'' +
                ", monthLimitTimes=" + monthLimitTimes +
                ", monthLimitAmount='" + monthLimitAmount + '\'' +
                ", openType=" + openType +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}