package com.yilin.app.service.com.yilin.manage.service.impl;

import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.IOrderMapper;
import com.yilin.app.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class OrderInfoService implements IOrderInfoService{

    @Autowired
    IOrderMapper orderMapper;

    @Override
    public List<Orders> selectAll() {
        return orderMapper.selectAll();
    }
}
