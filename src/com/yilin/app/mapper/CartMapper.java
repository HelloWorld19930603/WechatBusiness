package com.yilin.app.mapper;

import com.yilin.app.domain.Cart;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.Map;

public interface CartMapper extends IBaseMapper<Cart>{


    void deleteById(Map<String, Object> map) throws Exception;

    void updateNum(Cart cart) throws Exception;


    Cart selectNum(Cart cart) throws Exception;
}