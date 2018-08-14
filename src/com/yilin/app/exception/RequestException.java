package com.yilin.app.exception;

/**
 * Created by cc on 2018/8/14.
 */
public class RequestException extends Exception {

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RequestException(String msg){
        super(msg);
        setMsg(msg);
    }
}
