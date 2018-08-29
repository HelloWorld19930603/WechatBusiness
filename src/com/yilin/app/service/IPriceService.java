package com.yilin.app.service;

import com.yilin.app.domain.Price;

/**
 * Created by cc on 2018/7/26.
 */
public interface IPriceService {

    float findPrice(int roleId, int commId) throws Exception;

    Float[] findAllPrice(int commId) throws Exception;

    float findDefault(int commId) throws Exception;

    void addPrice(Price price)throws Exception;

    void editPrice(Float price, int commId, int i) throws Exception;
}
