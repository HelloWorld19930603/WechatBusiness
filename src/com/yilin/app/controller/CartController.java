package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Cart;
import com.yilin.app.service.ICartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("cart")
public class CartController {

    @Resource
    ICartService cartService;

    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(int userId,int start,int pageSize){
        ResultJson result;
        try {
            Page page =  cartService.getCarts(userId,start,pageSize);
            result = new ResultJson(true,"查询成功",page);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询失败");
        }
        return result;
    }

    @RequestMapping("addOne")
    @ResponseBody
    public ResultJson addOne(Cart cart){
        ResultJson result;
        try {
            cartService.addCart(cart);
            result = new ResultJson(true,"添加成功");
        } catch (Exception e) {
            result = new ResultJson(false,"添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updateOne")
    @ResponseBody
    public ResultJson updateOne(Cart cart){
        ResultJson result;
        try {
            cartService.updateCart(cart);
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("removeOne")
    @ResponseBody
    public ResultJson removeOne(int cartId,int userId){
        ResultJson result;
        try {
            cartService.deleteCart(cartId,userId);
            result = new ResultJson(true,"删除成功");
        } catch (Exception e) {
            result = new ResultJson(false,"删除失败");
            e.printStackTrace();
        }
        return result;
    }
}
