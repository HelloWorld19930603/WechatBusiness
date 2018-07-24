package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Cart;
import com.yilin.app.service.ICartService;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2018/7/23.
 */
@Service
public class CartService implements ICartService {


    @Override
    public Page getCarts(int userId, int start, int pageSieze) throws Exception {
        return null;
    }

    @Override
    public void addCart(Cart cart) throws Exception {

    }

    @Override
    public void deleteCart(int id, int userId) throws Exception {

    }

    @Override
    public void updateCart(Cart cart) throws Exception {

    }
}
