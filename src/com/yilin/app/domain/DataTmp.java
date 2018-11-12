package com.yilin.app.domain;

import java.util.Date;

public class DataTmp {
    private Integer id;

    private Integer serise;

    private Integer type;

    private String tempId;

    private Integer mode;

    private Integer status;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerise() {
        return serise;
    }

    public void setSerise(Integer serise) {
        this.serise = serise;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public DataTmp(Integer serise, Integer type, String tempId, Integer mode) {
        this.serise = serise;
        this.type = type;
        this.tempId = tempId;
        this.mode = mode;
        this.status = 1;
        this.time = new Date();
    }

    public DataTmp(){}
}