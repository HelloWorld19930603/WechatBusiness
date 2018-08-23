package com.yilin.app.mapper;

import com.yilin.app.domain.Cart;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CartMapper extends IBaseMapper<Cart> {


    void deleteById(Map<String, Object> map) throws Exception;

    void updateNum(Cart cart) throws Exception;

    Cart selectNum(@Param(value = "commId") int commId, @Param(value = "userId") int userId) throws Exception;
}