package com.yilin.system.service;

import com.yilin.app.domain.Rebate;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/22.
 */
public interface IRebateService {

     Rebate findOne(int id) throws Exception;

    List<Map<String,Object>> selectList(String name, Byte serise, Integer type, int start, int pageSize)throws Exception;

    void addOne(Rebate rebate) throws Exception;

    void editOne(Rebate rebate) throws Exception;

    void removeOne(int id)throws Exception;

    int getCount(String name, Byte serise, Integer type) throws Exception;

}
