package com.yilin.system.service.impl;

import com.yilin.app.mapper.HomeMapper;
import com.yilin.system.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/9/26.
 */
@Service
public class HomeService implements IHomeService {

    @Autowired
    HomeMapper homeMapper;

    @Override
    public Integer[] selectAll(String start, String end) {
        return homeMapper.selectAll(start,end);
    }

    @Override
    public List<Map<String,Object>> selectForSale(String start, String end) {
        return homeMapper.selectForSale(start,end);
    }

    @Override
    public List<Map<String,Object>> selectForDealer(String start, String end) {
        return homeMapper.selectForDealer(start,end);
    }
}
