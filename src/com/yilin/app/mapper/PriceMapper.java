package com.yilin.app.mapper;

import com.yilin.app.domain.Price;
import com.yilin.app.domain.PriceKey;
import com.yilin.app.mapper.base.IBaseMapper;

public interface PriceMapper  extends IBaseMapper<Price> {

    float selectPrice(PriceKey key) throws Exception;

    float selectPrice(int commId) throws Exception;
}