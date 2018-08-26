package com.yilin.system.service;

import com.yilin.app.domain.Rebate;

import java.util.List;

/**
 * Created by cc on 2018/8/22.
 */
public interface IRebateService {

     Rebate findOne(int id) throws Exception;

    List<Rebate> selectList(String name,Byte serise,int start,int pageSize)throws Exception;

    void addOne(Rebate rebate) throws Exception;

    void editOne(Rebate rebate) throws Exception;

    void removeOne(int id)throws Exception;
}
