package com.yilin.app.common;

import java.util.Date;

/**
 * Created by cc on 2018/7/29.
 */
public class UserInfo {

    private int id;
    private String name;
    private String headImg;
    private String sex;
    private int[] level = {0,9,9,9};
    private Date last_time;
    private Date curr_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int[] getLevel() {
        return level;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public Date getCurr_time() {
        return curr_time;
    }

    public void setCurr_time(Date curr_time) {
        this.curr_time = curr_time;
    }
}
