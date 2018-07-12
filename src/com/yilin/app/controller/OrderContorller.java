package com.yilin.app.controller;

import com.yilin.app.domain.Orders;
import com.yilin.app.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cc on 2018/7/9.
 */
@Controller
public class OrderContorller {

    @Autowired
    IOrderInfoService orderInfoService;


    @RequestMapping("/getOrders")
    @ResponseBody
    public List<Orders> getOrders(){
        return orderInfoService.selectAll();
    }



}
