package com.yilin.app.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/9/26.
 */
public interface HomeMapper {

    Integer[] selectAll(@Param("start") String start, @Param("end") String end);

    List<Map<String,Object>> selectForSale(@Param("start") String start, @Param("end") String end);

    List<Map<String,Object>> selectForDealer(@Param("start") String start, @Param("end") String end);
}
