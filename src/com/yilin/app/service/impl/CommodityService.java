package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Commodity;
import com.yilin.app.mapper.CommDetailMapper;
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
    @Resource
    CommDetailMapper commDetailMapper;


    @Override
    public Page selectPage(Integer type,Integer userId, Integer serise, int index, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("userId",userId);
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
    public Commodity selectById(int id,Integer userId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("userId",userId);
        return commodityMapper.selectOne(map);
    }


    @Override
    public int getCount(Integer type, Integer serise) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("serise",serise);
        return commodityMapper.count(map);
    }

    @Override
    public Float getPrice(int commId, Integer userId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("commId",commId);
        map.put("userId",userId);
        return commodityMapper.selectPrice(map);
    }

    @Override
    public List<String> selectDetails(int commId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("commId",commId);
        return commDetailMapper.selectUrls(map);
    }
}
