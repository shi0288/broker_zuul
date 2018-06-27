package com.xyauto.interact.broker.zuul.util.duiba;

import org.springframework.data.annotation.Id;

public class CreditConsumeResult {

    @Id
    private String id;
    private Boolean success;
    private String errorMessage = "";
    private String message = "";
    private String bizId;
    private Long credits;//用户积分余额
    private String localMessage;
    private Long subCredits;
    private String orderNum;//兑吧订单号


    public CreditConsumeResult() {
    }

    public CreditConsumeResult(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (success) {
            return "{'status':'ok','message':'" + message + "','errorMessage':'','bizId':'" + bizId + "','credits':'" + credits + "'}";
        } else {
            return "{'status':'fail','message':'" + message + "','errorMessage':'" + errorMessage + "','credits':'" + credits + "'}";
        }
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String getBizId() {
        return bizId;
    }


    public void setBizId(String bizId) {
        this.bizId = bizId;
    }


    public Long getCredits() {
        return credits;
    }


    public void setCredits(Long credits) {
        this.credits = credits;
    }


    public String getLocalMessage() {
        return localMessage;
    }

    public void setLocalMessage(String localMessage) {
        this.localMessage = localMessage;
    }

    public Long getSubCredits() {
        return subCredits;
    }

    public void setSubCredits(Long subCredits) {
        this.subCredits = subCredits;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
