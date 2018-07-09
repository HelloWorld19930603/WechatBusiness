package com.yilin.manage.service.com.yilin.manage.service.impl;

import com.yilin.manage.domain.Order;
import com.yilin.manage.mapper.IOrderMapper;
import com.yilin.manage.service.IOrderInfoService;
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
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }
}
