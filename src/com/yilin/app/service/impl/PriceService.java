package com.yilin.app.service.impl;

import com.yilin.app.domain.Price;
import com.yilin.app.domain.PriceKey;
import com.yilin.app.mapper.PriceMapper;
import com.yilin.app.service.IPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/26.
 */
@Service
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

    @Override
    public void addPrice(Price price) throws Exception {
        priceMapper.insert(price);
    }
}
