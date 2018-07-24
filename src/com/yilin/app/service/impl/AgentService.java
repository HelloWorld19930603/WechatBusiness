package com.yilin.app.service.impl;

import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.service.IAgentService;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2018/7/23.
 */
@Service
public class AgentService implements IAgentService{


    @Override
    public void addUpgrade(AgentUpgrade agentUpgrade) throws Exception {
        
    }

    @Override
    public int findLevel(int userId) throws Exception {
        return 0;
    }
}
