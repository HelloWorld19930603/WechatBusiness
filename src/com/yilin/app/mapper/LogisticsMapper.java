package com.yilin.app.mapper;

import com.yilin.app.domain.Logistics;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LogisticsMapper extends IBaseMapper<Logistics> {

     Logistics selectByPrimaryKey(@Param(value = "id") String id);

    void deleteByOrder(@Param(value = "orderId")String orderId);
}