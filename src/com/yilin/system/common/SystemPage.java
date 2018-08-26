package com.yilin.system.common;

/**
 * Created by cc on 2018/8/19.
 */
public class SystemPage {

    String status;

    int totals;

    Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SystemPage(int totals, Object data) {
        this.status = "success";
        this.totals = totals;
        this.data = data;
    }

    public SystemPage() {
        this.status = "failed";

    }
}
