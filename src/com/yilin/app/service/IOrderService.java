package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.exception.AccountException;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface IOrderService {

    Page selectPage(Integer userId, int index, int pageSize, Byte status) throws Exception;

    void updateStatus(String id, int userId, int status,Integer oldStatus) throws AccountException;

    Map<String,Object> findOrder(String id) throws Exception;

    String createOrder(int userId,Map<String,Object> orders) throws Exception;

    int getCount(Integer userId, Integer status) throws Exception;

    List<Map<String,Integer>> getAllCount(Integer userId) throws Exception;

    void payOrder(String id, int userId, String type) throws AccountException;

    void removeOrder(String id, int userId) throws Exception;

    void refund(String orderId, int userId, byte i) throws Exception;
}
