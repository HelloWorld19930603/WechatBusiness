package com.yilin.system.service;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/9/26.
 */
public interface IHomeService {

    Integer[] selectAll(String start, String end);

    List<Map<String,Object>> selectForSale(String start, String end);

    List<Map<String,Object>> selectForDealer(String start, String end);
}
