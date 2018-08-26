package com.yilin.app.domain;

public class Price extends PriceKey {
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public Price(Integer commId, Integer roleId, Float price) {
        super(commId, roleId);
        this.price = price;
    }

    public Price(Float price) {
        this.price = price;
    }
}