package com.yilin.app.domain;

import java.util.Date;

public class Orders {
    private String id;

    private Integer userId;

    private Integer addrId;

    private Byte status;

    private Date time;

    private String description;

    private Byte serise;

    private Float totals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getSerise() {
        return serise;
    }

    public void setSerise(Byte serise) {
        this.serise = serise;
    }

    public Float getTotals() {
        return totals;
    }

    public void setTotals(Float totals) {
        this.totals = totals;
    }
}