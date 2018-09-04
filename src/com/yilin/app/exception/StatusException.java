package com.yilin.app.exception;

/**
 * Created by cc on 2018/9/4.
 */
public class StatusException extends Exception {

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StatusException(String msg) {
        super(msg);
        setMsg(msg);
    }
}
