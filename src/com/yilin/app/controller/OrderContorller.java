package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Orders;
import com.yilin.app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cc on 2018/7/9.
 */
@Controller
@RequestMapping("order")
public class OrderContorller {

    @Autowired
    IOrderService orderService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage()  {
        ResultJson result;
        try {
            List<Orders> list = orderService.selectAll();
            result = new ResultJson(true,"查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询失败");
        }
        return result;
    }

}
