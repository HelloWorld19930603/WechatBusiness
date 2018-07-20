package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Orders;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface IOrderService {

     Page selectPage(Integer userId,int index,int pageSize) throws Exception;

     void updateStatus(int id,int status) throws Exception;

     Orders findOrder(int id) throws Exception;

     void createOrder(Orders orders) throws Exception;

     int getCount(int userId) throws Exception;
}
