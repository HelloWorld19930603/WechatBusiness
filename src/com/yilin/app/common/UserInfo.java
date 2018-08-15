package com.yilin.app.common;

/**
 * Created by cc on 2018/7/29.
 */
public class UserInfo {

    private int id;
    private String message_code;
    private long message_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage_code() {
        return message_code;
    }

    public void setMessage_code(String message_code) {
        this.message_code = message_code;
    }

    public long getMessage_time() {
        return message_time;
    }

    public void setMessage_time(long message_time) {
        this.message_time = message_time;
    }
}
