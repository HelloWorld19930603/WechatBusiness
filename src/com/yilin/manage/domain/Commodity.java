package com.yilin.manage.domain;

import java.util.Date;

/**
 * Created by cc on 2018/7/11.
 */
public class Commodity {

    int id;
    //系列
    int series;
    //库存
    int stock;
    //商品名
    String name;
    //商品描述
    String descript;
    //商品类别
    String type;
    //商品重量
    float scale;
    //商品二维码
    String qr_code;
    //保质期
    String quality;
    //生产日期
    Date start;
    //商品图片
    String img;
    //规格
    String specifications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}


