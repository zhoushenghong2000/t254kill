package com.zking.killprovider.model;

import java.util.Date;

public class ItemKillSuccess {
    private String code;

    private Integer itemId;

    private Integer killId;

    private String userId;

    private Byte status;

    private Date createTime;

    public ItemKillSuccess(String code, Integer itemId, Integer killId, String userId, Byte status, Date createTime) {
        this.code = code;
        this.itemId = itemId;
        this.killId = killId;
        this.userId = userId;
        this.status = status;
        this.createTime = createTime;
    }

    public ItemKillSuccess() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getKillId() {
        return killId;
    }

    public void setKillId(Integer killId) {
        this.killId = killId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}