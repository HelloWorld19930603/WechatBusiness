package com.yilin.app.controller;

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


    @RequestMapping("findList")
    @ResponseBody
    public List<Orders> findList() throws Exception {
        return orderService.selectAll();
    }

}
