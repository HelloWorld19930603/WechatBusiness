package com.yilin.app.mapper;

import com.yilin.app.domain.CommDetail;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.List;
import java.util.Map;

public interface CommDetailMapper extends IBaseMapper<CommDetail>{

    List<String> selectUrls(Map<String,Object> map);
}