package com.yilin.app.mapper;

import com.yilin.app.domain.Orders;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdersMapper extends IBaseMapper<Orders>{

    void updateStatus(Map<String, Object> map) throws Exception;


    void deleteById(Map<String, Object> map) throws Exception;

    Map<String,Object> selectById(String id) throws Exception;

    List<Map<String,Object>> selectList(Map<String, Object> map) throws Exception;

    List<Map<String,Integer>> countAll(Map<String, Object> map);

    byte selectStatus(@Param(value = "orderId") String orderId);
}