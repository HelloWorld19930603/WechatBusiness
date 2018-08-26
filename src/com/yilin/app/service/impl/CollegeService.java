package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.College;
import com.yilin.app.mapper.CollegeMapper;
import com.yilin.app.service.ICollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/24.
 */
@Service
public class CollegeService implements ICollegeService{

    @Resource
    CollegeMapper collegeMapper;

    @Override
    public Page findPage(Byte type,int start, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(start - 1) * pageSize);
        map.put("pageSize",pageSize);
        map.put("type",type);
        List item = collegeMapper.selectPage(map);
        Page page = new Page(pageSize,start,item.size(),item);
        return page;
    }

    @Override
    public List findList(Byte type, String title, int start, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(start - 1) * pageSize);
        map.put("pageSize",pageSize);
        map.put("type",type);
        map.put("title",title);
        List item = collegeMapper.selectPage(map);
        return item;
    }

    @Override
    public int getCount(Byte type) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        return collegeMapper.count(map);
    }

    @Override
    public void addOne(String title, String content, String img, String video, byte type) throws Exception {
        College college = new College();
        college.setContent(content);
        college.setTitle(title);
        college.setImg(img);
        college.setType(type);
        college.setVideo(video);
        college.setTime(new Date());
        collegeMapper.insertSelective(college);
    }

    @Override
    public void removeOne(int id) throws Exception {
        collegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editOne(College college) throws Exception {
        collegeMapper.updateByPrimaryKeySelective(college);
    }
}
