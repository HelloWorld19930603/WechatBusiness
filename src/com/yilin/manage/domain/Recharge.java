package com.yilin.manage.domain;

import java.util.Date;

/**
 * Created by cc on 2018/7/11.
 */
public class Recharge {

    int id;
    //用户id
    int user_id;
    //充值的所属系列
    int serise;
    //充值金额
    float money;
    //充值日期
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

    public int getSerise() {
        return serise;
    }

    public void setSerise(int serise) {
        this.serise = serise;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
