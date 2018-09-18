package com.yilin.system.service.impl;

import com.yilin.app.domain.Rebate;
import com.yilin.app.mapper.RebateMapper;
import com.yilin.app.mapper.WalletMapper;
import com.yilin.system.service.IRebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/22.
 */
@Service
public class RebateService implements IRebateService {
    @Autowired
    RebateMapper rebateMapper;
    @Autowired
    WalletMapper walletMapper;

    @Override
    public Rebate findOne(int id) throws Exception {
        return null;
    }

    @Override
    public List<Map<String,Object>> selectList(String name,  Byte serise, Integer type,int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        map.put("type", type);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return rebateMapper.selectList2(map);
    }

    @Override
    public void addOne(Rebate rebate) throws Exception {
        rebate.setTime(new Date());
        rebateMapper.insertSelective(rebate);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", rebate.getUserId());
        map.put("serise", rebate.getSerise());
        map.put("money", rebate.getMoney());
        walletMapper.addMoney(map);
    }

    @Override
    public void editOne(Rebate rebate) throws Exception {
        rebateMapper.updateByPrimaryKeySelective(rebate);
    }

    @Override
    public void removeOne(int id) throws Exception {
        rebateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getCount(String name, Byte serise,Integer type) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        map.put("type", type);
        return rebateMapper.count(map);
    }
}
