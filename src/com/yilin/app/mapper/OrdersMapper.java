package com.yilin.app.mapper;

import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.List;
import java.util.Map;

public interface OrdersMapper extends IBaseMapper<Orders>{

    void updateStatus(Map<String,Object> map) throws Exception;


    void deleteById(Map<String,Object> map) throws Exception;

    Orders selectById(String id) throws Exception;

    List<Map<String,Object>> selectPage2(Map<String,Object> map) throws Exception;
}