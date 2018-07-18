package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Commodity;

/**
 * Created by cc on 2018/7/17.
 */
public interface ICommodityService {
    Page selectPage(Integer type, Integer serise, int index, int pageSize) throws Exception;

    Commodity selectById(int id) throws Exception;

    int getCount(Integer type, Integer serise) throws Exception;
}
