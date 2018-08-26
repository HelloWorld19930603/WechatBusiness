package com.yilin.system.service.impl;

import com.yilin.app.domain.Poster;
import com.yilin.app.mapper.PosterMapper;
import com.yilin.system.service.IPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/7.
 */
@Service
public class PosterService implements IPosterService{

    @Autowired
    PosterMapper posterMapper;

    @Override
    public int selectNum(String page, Byte type) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("type", type);
        return posterMapper.count(map);
    }

    @Override
    public List<Map<String, Object>> selectList(String page, Byte type, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("type", type);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        return posterMapper.selectList(map);
    }

    @Override
    public void insertPoster(Poster poster) throws Exception {
        poster.setTime(new Date());
        posterMapper.insertSelective(poster);
    }
}
