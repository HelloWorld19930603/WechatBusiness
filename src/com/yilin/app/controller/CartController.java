package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("cart")
public class CartController {


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(int userId,int start,int pageSize){
        ResultJson result;
        try {
            result = new ResultJson(true,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询失败");
        }
        return result;
    }

    @RequestMapping("addOne")
    @ResponseBody
    public ResultJson addOne(int userId, int commId,int num){
        ResultJson result;
        try {
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
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }
}
