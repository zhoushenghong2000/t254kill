package com.zking.killprovider.model;

import java.util.Date;

public class ItemKill {
    private Integer id;

    private Integer itemId;

    private Integer totals;

    private Date startTime;

    private Date endTime;

    private Byte isActive;

    private Date createTime;

    public ItemKill(Integer id, Integer itemId, Integer totals, Date startTime, Date endTime, Byte isActive, Date createTime) {
        this.id = id;
        this.itemId = itemId;
        this.totals = totals;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.createTime = createTime;
    }

    public ItemKill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTotal() {
        return totals;
    }

    public void setTotal(Integer total) {
        this.totals = total;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}