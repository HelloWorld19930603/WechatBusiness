package com.yilin.app.mapper;

import com.yilin.app.domain.Commodity;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CommodityMapper  extends IBaseMapper<Commodity> {

    Float selectPrice(Map<String, Object> map);

    Float[] selectAllPrice(Map<String, Object> map);


    int selectByType(@Param("type") int type);

    void updateByType(@Param("type")byte type);
}