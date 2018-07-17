package com.yilin.app.service;

import com.yilin.app.domain.Address;

import java.util.List;

/**
 * Created by cc on 2018/7/17.
 */
public interface IAddressService {


    List<Address> findAllByUserId(Integer userId) throws Exception;

    Address findDefault(int userId) throws Exception;

    void updateDefault(int id, int userId) throws Exception;
}
