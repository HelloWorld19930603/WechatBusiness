package com.yilin.system.service.impl;

import com.yilin.app.domain.Logistics;
import com.yilin.app.mapper.ExpressMapper;
import com.yilin.app.mapper.LogisticsMapper;
import com.yilin.system.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cc on 2018/8/28.
 */
@Service
public class LogisticsService implements ILogisticsService {

    @Autowired
    ExpressMapper expressMapper;
    @Autowired
    LogisticsMapper logisticsMapper;

    @Override
    public List findExpress() throws Exception {
        return expressMapper.selectPage(null);
    }

    @Override
    public Logistics findOne(String id) {
        return logisticsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addOne(Logistics logistics) throws Exception {
        logisticsMapper.insertSelective(logistics);
    }

    @Override
    public void editOne(Logistics logistics) throws Exception {
        logisticsMapper.updateByPrimaryKey(logistics);
    }

    @Override
    public void removeByOrder(String orderId) throws Exception {
        logisticsMapper.deleteByOrder(orderId);
    }
}
