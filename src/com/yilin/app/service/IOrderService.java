package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Orders;
import com.yilin.app.utils.AccountException;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface IOrderService {

    Page selectPage(Integer userId, int index, int pageSize) throws Exception;

    void updateStatus(String id, int userId, int status) throws AccountException;

    Orders findOrder(String id) throws Exception;

    String createOrder(Orders orders) throws Exception;

    int getCount(Integer userId, Integer status) throws Exception;

    void payOrder(String id,int userId,float money,String type) throws AccountException;

    void removeOrder(String id, int userId) throws Exception;
}
