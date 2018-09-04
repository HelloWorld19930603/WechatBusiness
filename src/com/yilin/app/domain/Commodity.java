package com.yilin.app.domain;

import java.util.Date;

public class Commodity {
    private Integer id;

    private Byte serise;

    private Integer stock;

    private String name;

    private String eName;

    private String descript;

    private String type;

    private String scale;

    private String qrCode;

    private Date start;

    private String img;

    private Byte status;

    private Float aPrice;

    private Float mPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getSerise() {
        return serise;
    }

    public void setSerise(Byte serise) {
        this.serise = serise;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Float getaPrice() {
        return aPrice;
    }

    public void setaPrice(Float aPrice) {
        this.aPrice = aPrice;
    }

    public Float getmPrice() {
        return mPrice;
    }

    public void setmPrice(Float mPrice) {
        this.mPrice = mPrice;
    }
}