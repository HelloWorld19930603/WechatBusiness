package com.yilin.app.service;

import com.yilin.app.domain.AgentUpgrade;

/**
 * Created by cc on 2018/7/17.
 */
public interface IAgentService {

    void addUpgrade(AgentUpgrade agentUpgrade) throws Exception;


    int findLevel(int userId, byte serise) throws Exception;

}
