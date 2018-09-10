package com.yilin.app.service;

import com.yilin.app.exception.AccountException;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface IOrderService {

    List selectList(Integer userId, int index, int pageSize, Byte status) throws Exception;

    List<Map<String, Object>> selectDetails(String orderId) throws Exception;

    void updateStatus(String id, Integer userId, int status, Integer oldStatus) throws AccountException;

    Map<String,Object> findOrder(String id) throws Exception;

    String createOrder(int userId,Map<String,Object> orders) throws Exception;

    int getCount(Integer userId, Byte status, Byte serise) throws Exception;

    List<Map<String,Integer>> getAllCount(Integer userId) throws Exception;

    void payOrder(String id, int userId, String type) throws AccountException;

    void removeOrder(String id, int userId) throws Exception;

    void refund(String orderId, int userId, byte i) throws Exception;

    List selectList2(Integer userId, Byte status, Byte serise, int start, int pageSize) throws Exception;

    void editMoney(String id,float money) throws Exception;
}
