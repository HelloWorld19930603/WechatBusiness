package com.yilin.system.service.impl;

import com.yilin.app.domain.DataTmp;
import com.yilin.app.mapper.DataTmpMapper;
import com.yilin.system.service.IDataTmpService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/11/11.
 */
@Service
public class DataTmpService implements IDataTmpService{

    @Autowired
    public DataTmpMapper dataTmpMapper;

    @Override
    public void addOne(DataTmp dataTmp) throws Exception {
        dataTmpMapper.insert(dataTmp);
    }

    @Override
    public void updateOne(DataTmp dataTmp) throws Exception {
        dataTmpMapper.updateByPrimaryKeySelective(dataTmp);
    }

    @Override
    public List<DataTmp> selectList(Integer status, Long time) throws Exception {
        Map<String,Object> map = new HashedMap();
        if(time != null){
            map.put("time",new Date(time));
        }else {
            map.put("status", status);
        }
        return dataTmpMapper.selectAll(map);
    }
}
