package com.yilin.system.service.impl;

import com.yilin.app.domain.RebateRule;
import com.yilin.app.mapper.RebateRuleMapper;
import com.yilin.system.service.IRebateRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/9/2.
 */
@Service
public class RebateRuleService implements IRebateRuleService {

    @Autowired
    RebateRuleMapper rebateRuleMapper;

    @Override
    public void removeOne(int id) throws Exception {
        rebateRuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editOne(RebateRule rebateRule) throws Exception {
        rebateRuleMapper.updateByPrimaryKey(rebateRule);
    }

    @Override
    public void addOne(RebateRule rebateRule) throws Exception {
        rebateRuleMapper.insertSelective(rebateRule);
    }

    @Override
    public List selectList(String name, Byte serise, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return rebateRuleMapper.selectList(map);
    }

    @Override
    public int getCount(String name, Byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        return rebateRuleMapper.count(map);
    }

    @Override
    public RebateRule selectOne(int id) throws Exception {
        return rebateRuleMapper.selectByPrimaryKey(id);
    }
}
