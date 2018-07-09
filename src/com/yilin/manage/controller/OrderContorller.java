package com.yilin.manage.controller;

import com.yilin.manage.domain.Order;
import com.yilin.manage.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Controller
public class OrderContorller {

    @Autowired
    IOrderInfoService orderInfoService;


    @RequestMapping("/getOrders")
    @ResponseBody
    public List<Order> getOrders(){
        return orderInfoService.selectAll();
    }
}
