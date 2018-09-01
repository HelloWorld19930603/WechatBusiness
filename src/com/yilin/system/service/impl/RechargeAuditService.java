package com.yilin.system.service.impl;

import com.yilin.app.domain.Recharge;
import com.yilin.app.mapper.RechargeMapper;
import com.yilin.system.service.IRechargeAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/30.
 */
@Service
public class RechargeAuditService implements IRechargeAuditService{

    @Autowired
    RechargeMapper rechargeMapper;

    @Override
    public void updateStatus(byte status) throws Exception {

    }

    @Override
    public int getCount(Byte status, Byte serise, String phone, String userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("serise", serise);
        map.put("status", status);
        return rechargeMapper.count(map);
    }

    @Override
    public List selectList(Byte status, Byte serise, String phone, String userId,int start,int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("serise", serise);
        map.put("status", status);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return rechargeMapper.selectPage(map);
    }

    @Override
    public Recharge selectOne(int id) throws Exception {
        return rechargeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editOne(Recharge recharge) throws Exception {
        rechargeMapper.updateByPrimaryKeySelective(recharge);
    }

    @Override
    public void removeOne(int id) throws Exception {

    }

    @Override
    public void audit(int id, byte status) throws Exception {

    }
}
