package com.yilin.system.service.impl;

import com.yilin.app.domain.Rebate;
import com.yilin.app.mapper.RebateMapper;
import com.yilin.system.service.IRebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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

    @Override
    public Rebate findOne(int id) throws Exception {
        return null;
    }

    @Override
    public List<Rebate> selectList(String name, Byte serise, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return rebateMapper.selectPage(map);
    }

    @Override
    public void addOne(Rebate rebate) throws Exception {
        rebateMapper.insertSelective(rebate);
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
    public int selectCount(String name, Byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("serise", serise);
        return rebateMapper.count(map);
    }
}
