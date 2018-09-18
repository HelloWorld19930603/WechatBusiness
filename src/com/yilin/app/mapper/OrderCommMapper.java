package com.yilin.app.mapper;

import com.yilin.app.domain.OrderComm;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderCommMapper extends IBaseMapper<OrderComm>{

    void deleteAll(@Param("orderId") String orderId) throws Exception;

    float countMoney(Map<String, Object> map) throws Exception;

    Map selectByCode(@Param("code")String code)throws Exception;
}