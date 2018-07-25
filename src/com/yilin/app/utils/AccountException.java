package com.yilin.app.utils;

/**
 * Created by cc on 2018/7/25.
 */
public class AccountException extends  Exception {

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AccountException(String msg){
        super(msg);
        setMsg(msg);
    }

}
