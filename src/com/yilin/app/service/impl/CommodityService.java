package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Commodity;
import com.yilin.app.mapper.CommodityMapper;
import com.yilin.app.service.ICommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/18.
 */
@Service
public class CommodityService implements ICommodityService {

    @Resource
    CommodityMapper commodityMapper;

    @Override
    public Page selectPage(Integer type, Integer serise, int index, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("serise",serise);
        map.put("start",(index-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Commodity> list = commodityMapper.selectPage(map);
        Page page = new Page(pageSize,index,list.size(),list);
        return page;
    }

    @Override
    public List<Commodity> selectALl(Integer type, Integer serise) throws Exception {
        return null;
    }

    @Override
    public Commodity selectById(int id) throws Exception {

        return commodityMapper.selectByPrimaryKey(id);
    }


    @Override
    public int getCount(Integer type, Integer serise) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("serise",serise);
        return commodityMapper.count(map);
    }
}