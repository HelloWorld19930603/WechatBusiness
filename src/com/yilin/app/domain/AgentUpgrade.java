package com.yilin.app.domain;

/**
 * Created by cc on 2018/7/11.
 */
public class AgentUpgrade {

    int id;
    //用户id
    int user_id;
    //当前级别
    int current_level;
    //申请代理级别
    int apply_level;
    //申请人姓名
    String name;
    //上传凭证
    String voucher;
    //描述
    String descript;
    //申请状态 0表示待审核  1表示正在审核  2表示审核成功 3表示审核失败
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

    public int getCurrent_level() {
        return current_level;
    }

    public void setCurrent_level(int current_level) {
        this.current_level = current_level;
    }

    public int getApply_level() {
        return apply_level;
    }

    public void setApply_level(int apply_level) {
        this.apply_level = apply_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
