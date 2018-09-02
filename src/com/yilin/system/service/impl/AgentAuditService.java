package com.yilin.system.service.impl;

import com.yilin.app.domain.Agent;
import com.yilin.app.mapper.AgentMapper;
import com.yilin.system.service.IAgentAuditService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/30.
 */
@Service
public class AgentAuditService implements IAgentAuditService {

    @Autowired
    AgentMapper agentMapper;

    @Override
    public void updateStatus(byte status) throws Exception {

    }

    @Override
    public int getCount(Byte status, Byte serise, String phone, String name) throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("status", status);
        map.put("serise", serise);
        map.put("phone", phone);
        map.put("name", name);
        return agentMapper.count(map);
    }

    @Override
    public List selectList(Byte status, Byte serise, String phone, String name, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("status", status);
        map.put("serise", serise);
        map.put("phone", phone);
        map.put("name", name);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return agentMapper.selectList(map);
    }

    @Override
    public Map selectOne(int id) throws Exception {
        return null;
    }

    @Override
    public void removeOne(int id) throws Exception {

    }

    @Override
    public void audit(int id, byte status) throws Exception {

    }

    @Override
    public void addOne(Agent agent) throws Exception {
        agentMapper.insertSelective(agent);
    }
}
