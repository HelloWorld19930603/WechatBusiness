package com.yilin.manage.domain;

/**
 * Created by Administrator on 2018/7/11.
 */
public class Price {

    //商品id
    int comm_id;
    //角色id
    int role_id;
    //展示价格
    float price;
    //价格图片
    String img_url;

    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
