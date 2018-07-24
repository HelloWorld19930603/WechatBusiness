package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.OrdersMapper;
import com.yilin.app.service.IOrderService;
import com.yilin.app.utils.OrderNumberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Page selectPage(Integer userId, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("index", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Orders> list = ordersMapper.selectAll(map);
        Page page = new Page(pageSize, start, list.size(), list);
        return page;
    }

    @Override
    public void updateStatus(int id, int userId, int status) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("status", status);
        map.put("id", id);
        ordersMapper.updateStatus(map);
    }

    @Override
    public Orders findOrder(int id) throws Exception {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void createOrder(Orders orders) throws Exception {
        orders.setTime(new Date());
        orders.setIdentifier(OrderNumberBuilder.getOrderIdByUUId());
        ordersMapper.insert(orders);
    }

    @Override
    public int getCount(Integer userId, Integer status) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("status", status);
        return ordersMapper.count(map);
    }

    @Override
    public void payOrder(int id, int userId) throws Exception {

    }

    @Override
    public void removeOrder(int id, int userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("id", id);
        ordersMapper.deleteById(map);
    }
}
