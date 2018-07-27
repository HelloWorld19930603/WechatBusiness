package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Cart;

/**
 * Created by cc on 2018/7/17.
 */
public interface ICartService {

    Page getCarts(int userId,int start,int pageSieze) throws Exception;

    void addCart(Cart cart) throws Exception;

    void deleteCart(int id,int userId) throws Exception;

    void updateCart(Cart cart) throws Exception;

}
