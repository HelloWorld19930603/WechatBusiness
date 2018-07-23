package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.OrdersMapper;
import com.yilin.app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page selectPage(Integer userId, int pageIndex, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("index", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Orders> list = ordersMapper.selectAll(map);
        Page page = new Page(pageSize, pageIndex, list.size(), list);
        return page;
    }

    @Override
    public void updateStatus(int id, int status) throws Exception {

    }

    @Override
    public Orders findOrder(int id) throws Exception {
        return null;
    }

    @Override
    public void createOrder(Orders orders) throws Exception {

    }

    @Override
    public int getCount(int userId, Integer status) throws Exception {
        return 0;
    }

    @Override
    public void payOrder(int id, int userId) throws Exception {

    }

    @Override
    public void removeOrder(int id, int userId) throws Exception {

    }
}
