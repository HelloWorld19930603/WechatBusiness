package com.yilin.app.service.impl;

import com.yilin.app.domain.PriceKey;
import com.yilin.app.mapper.PriceMapper;
import com.yilin.app.service.IPriceService;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/26.
 */
public class PriceService implements IPriceService {

    @Resource
    PriceMapper priceMapper;

    @Override
    public float findPrice(int roleId, int commId) throws Exception {

        return priceMapper.selectPrice(new PriceKey(commId,roleId));
    }

    @Override
    public float findDefault(int commId) throws Exception {
        return 0;
    }
}
