package com.yilin.system.service;

import com.yilin.app.domain.Logistics;

import java.util.List;

/**
 * Created by cc on 2018/8/28.
 */
public interface ILogisticsService {

    List findExpress() throws Exception;

    Logistics findOne(String id);

    void addOne(Logistics logistics) throws Exception;

    void editOne(Logistics logistics) throws Exception;
}
