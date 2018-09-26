package com.yilin.system.service.impl;

import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.mapper.AgentUpgradeMapper;
import com.yilin.app.mapper.UserRoleMapper;
import com.yilin.system.service.IAgentUpgradeService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/30.
 */
@Service
public class AgetnUpgradeAutidService implements IAgentUpgradeService {

    @Autowired
    AgentUpgradeMapper agentUpgradeMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void updateStatus(byte status) throws Exception {

    }

    @Override
    public int getCount(Byte status, Byte serise, String phone, String name) throws Exception {
        Map<String,Object> map = new HashedMap();
        map.put("status",status);
        map.put("serise",serise);
        map.put("phone",phone);
        map.put("name",name);
        return agentUpgradeMapper.count(map);
    }

    @Override
    public List selectList(Byte status, Byte serise, String phone, String name,int start,int pageSize) throws Exception {
        Map<String,Object> map = new HashedMap();
        map.put("status",status);
        map.put("serise",serise);
        map.put("phone",phone);
        map.put("name",name);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return  agentUpgradeMapper.selectList(map);
    }

    @Override
    public Map selectOne(int id) throws Exception {
        return null;
    }

    @Override
    public void removeOne(int id) throws Exception {

    }

    @Override
    public void audit(int id, byte status, int userId, int level, int serise, int auditor,String remark) throws Exception {
        if(status == 2){
            userRoleMapper.updateLevel(userId,serise,level);
        }
        AgentUpgrade agentUpgrade = new AgentUpgrade();
        agentUpgrade.setAuditor(auditor);
        agentUpgrade.setStatus(status);
        agentUpgrade.setId(id);
        agentUpgrade.setsTime(new Date());
        agentUpgrade.setRemark(remark);
        agentUpgradeMapper.updateByPrimaryKeySelective(agentUpgrade);
    }

    @Override
    public void addOne(AgentUpgrade agentUpgrade) throws Exception {
        agentUpgradeMapper.insertSelective(agentUpgrade);
    }
}
