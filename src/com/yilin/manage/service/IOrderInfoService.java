package com.yilin.manage.service;

import com.yilin.manage.domain.Orders;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface IOrderInfoService {

    public List<Orders> selectAll();
}
