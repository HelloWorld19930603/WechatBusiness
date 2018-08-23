package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Cart;
import com.yilin.app.mapper.CartMapper;
import com.yilin.app.service.ICartService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/23.
 */
@Service
public class CartService implements ICartService {


    @Resource
    CartMapper cartMapper;

    @Override
    public Page getCarts(int userId, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        List list = cartMapper.selectList(map);
        Page page = new Page(pageSize, start, list.size(), list);
        return page;
    }

    @Override
    public void addCart(int commId,int num,int userId) throws Exception {
        Cart dikCart = cartMapper.selectNum(commId,userId);
        if (dikCart != null) {
            dikCart.setUserId(userId);
            dikCart.setNum(dikCart.getNum() + num);
            cartMapper.updateNum(dikCart);
        } else {
            Cart cart = new Cart();
            cart.setCommId(commId);
            cart.setNum(num);
            cart.setUserId(userId);
            cart.setTime(new Date());
            cartMapper.insert(cart);
        }
    }

    @Override
    public void deleteCart(int id, int userId) throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("id", id);
        map.put("userId", userId);
        cartMapper.deleteById(map);
    }

    @Override
    public void updateCart(Cart cart) throws Exception {
        cartMapper.updateNum(cart);
    }
}
