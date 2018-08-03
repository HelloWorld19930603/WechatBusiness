package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Commodity;

import java.util.List;

/**
 * Created by cc on 2018/7/17.
 */
public interface ICommodityService {
    Page selectPage(Integer type,Integer userId, Integer serise, int index, int pageSize) throws Exception;

    List<Commodity> selectALl(Integer type,Integer serise) throws  Exception;

    Commodity selectById(int id,Integer userId) throws Exception;

    int getCount(Integer type, Integer serise) throws Exception;

    Float getPrice(int commId,Integer userId)throws Exception;
}
