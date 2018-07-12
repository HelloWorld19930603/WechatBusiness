package com.yilin.app.domain;

import java.util.Date;

/**
 * 订单
 * Created by Administrator on 2018/7/9.
 */
public class Orders {


    int id;
    //关联用户id
    int user_id;
    //订单编号
    long  identifier;
    //关联商品id
    int comm_id;
    //购买数量
    int num;
    //购买单价
    float price;
    //订单状态 0代表未付款 1代表已付款  2代表已发货 3代表订单已完成 4代表退款中 5代表退货中 6代表退款成功 7代表订单已关闭
    byte status;
    //下单实际
    Date time;

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

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
