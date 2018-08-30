package com.yilin.system.service.impl;

import com.yilin.app.mapper.RechargeMapper;
import com.yilin.system.service.IRechargeAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int getCount(Byte status, Byte serise, String phone, String name) throws Exception {
        return 0;
    }

    @Override
    public List selectList(Byte status, Byte serise, String phone, String name) throws Exception {
        return null;
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
}
