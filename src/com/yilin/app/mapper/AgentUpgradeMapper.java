package com.yilin.app.mapper;

import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AgentUpgradeMapper extends IBaseMapper<AgentUpgrade> {

    void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);

}