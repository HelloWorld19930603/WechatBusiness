package com.yilin.app.mapper;

import com.yilin.app.domain.Commodity;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.Map;

public interface CommodityMapper  extends IBaseMapper<Commodity> {

    Float selectPrice(Map<String, Object> map);
}