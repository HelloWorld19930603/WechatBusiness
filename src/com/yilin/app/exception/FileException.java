package com.yilin.app.exception;

/**
 * Created by cc on 2018/7/27.
 */
public class FileException extends Exception{

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FileException(String msg){
        super(msg);
        setMsg(msg);
    }
}
