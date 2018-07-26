package com.yilin.app.service;

/**
 * Created by cc on 2018/7/26.
 */
public interface IPriceService {

    float findPrice(int roleId,int commId) throws Exception;

    float findDefault(int commId) throws Exception;
}
