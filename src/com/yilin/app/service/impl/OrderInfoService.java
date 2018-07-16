package com.yilin.app.service.impl;

import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.OrdersMapper;
import com.yilin.app.service.IOrderInfoService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class OrderInfoService implements IOrderInfoService{

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> selectAll() throws Exception {
        return ordersMapper.selectAll(new HashedMap());
    }
}
