package com.yilin.app.mapper;

import com.yilin.app.domain.Logistics;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LogisticsMapper extends IBaseMapper<Logistics> {

    public Logistics selectByPrimaryKey(@Param(value = "id") String id);
}