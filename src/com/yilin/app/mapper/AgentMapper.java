package com.yilin.app.mapper;

import com.yilin.app.domain.Agent;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AgentMapper extends IBaseMapper<Agent>{

    void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);
}