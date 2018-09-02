package com.yilin.system.service;

import com.yilin.app.domain.RebateRule;

import java.util.List;

/**
 * Created by cc on 2018/9/2.
 */
public interface IRebateRuleService {

    void removeOne(int id) throws Exception;

    void editOne(RebateRule rebateRule) throws Exception;

    void addOne(RebateRule rebateRule) throws Exception;

    List selectList(String name, Byte serise, int start, int pageSize) throws Exception;

    int getCount(String name, Byte serise) throws Exception;

    RebateRule selectOne(int id) throws Exception;
}
