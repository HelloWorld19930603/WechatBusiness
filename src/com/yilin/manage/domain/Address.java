package com.yilin.manage.domain;

/**
 * Created by Administrator on 2018/7/11.
 */
public class Address {

    int id;
    //关联用户id
    int user_id;
    //地址详情
    String address;
    //是否默认   1表示是默认地址
    byte status;
}
