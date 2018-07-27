package com.yilin.app.service.impl;

import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.mapper.AgentUpgradeMapper;
import com.yilin.app.mapper.RoleMapper;
import com.yilin.app.service.IAgentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2018/7/23.
 */
@Service
public class AgentService implements IAgentService{


    @Resource
    AgentUpgradeMapper upgradeMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public void addUpgrade(AgentUpgrade agentUpgrade) throws Exception {
        upgradeMapper.insert(agentUpgrade);
    }

    @Override
    public int findLevel(int userId,byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("serise", serise);
        return roleMapper.findRole(map);
    }
}
