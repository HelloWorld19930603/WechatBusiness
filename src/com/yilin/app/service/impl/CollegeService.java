package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.mapper.CollegeMapper;
import com.yilin.app.service.ICollegeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/24.
 */
public class CollegeService implements ICollegeService{

    @Resource
    CollegeMapper collegeMapper;

    @Override
    public Page findPage(int start, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(start - 1) * pageSize);
        map.put("pageSize",pageSize);
        List item = collegeMapper.selectPage(map);
        Page page = new Page(pageSize,start,item.size(),item);
        return page;
    }
}
