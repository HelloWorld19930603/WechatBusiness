package com.yilin.app.service.impl;

import com.yilin.app.domain.Price;
import com.yilin.app.domain.PriceKey;
import com.yilin.app.mapper.PriceMapper;
import com.yilin.app.service.IPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public Float[] findAllPrice(int commId) throws Exception {
        return priceMapper.selectAllPrice(commId);
    }

    @Override
    public float findDefault(int commId) throws Exception {
        return priceMapper.selectPrice(new PriceKey(commId,0));
    }

    @Override
    public void addPrice(Price price) throws Exception {
        priceMapper.insert(price);
    }

    @Override
    public void editPrice(Float price, int commId,int roleId) throws Exception {
        priceMapper.updateByPrimaryKeySelective(new Price(commId,roleId,price));
    }


}
