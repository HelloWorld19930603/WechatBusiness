package com.yilin.app.mapper;

import com.yilin.app.domain.Rebate;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.List;
import java.util.Map;

public interface RebateMapper extends IBaseMapper<Rebate>{

    List<Map<String,Object>> selectList2(Map<String, Object> map);
}