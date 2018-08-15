package com.yilin.app.domain;

public class Logistics {
    private String id;

    private String com;

    private String no;

    private String orderId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com == null ? null : com.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}