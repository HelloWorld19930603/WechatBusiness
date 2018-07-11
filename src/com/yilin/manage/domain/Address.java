package com.yilin.manage.domain;

/**
 *
 * Created by cc on 2018/7/11.
 */
public class Address {

    int id;
    //关联用户id
    int user_id;
    //收货人姓名
    String name;
    //收货人手机号码
    int phone;
    //省市区
    String ssq;
    //地址详情
    String addr;
    //是否默认   1表示是默认地址
    byte status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSsq() {
        return ssq;
    }

    public void setSsq(String ssq) {
        this.ssq = ssq;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
