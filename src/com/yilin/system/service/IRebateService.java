package com.yilin.system.service;

import com.yilin.app.domain.Rebate;

import java.util.List;

/**
 * Created by cc on 2018/8/22.
 */
public interface IRebateService {

    public Rebate findOne(int id) throws Exception;

    public void addOne(Rebate rebate) throws Exception;

    public void deleteOne(int id) throws Exception;

    public void editOne(Rebate rebate) throws Exception;

    public List<Rebate> findPage(int start,int pageSize) throws Exception;
}
