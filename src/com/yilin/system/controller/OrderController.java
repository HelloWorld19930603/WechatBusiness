package com.yilin.system.controller;

import com.yilin.app.service.IOrderService;
import com.yilin.system.common.SystemPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cc on 2018/8/27.
 */
@Controller
public class OrderController {

    @Autowired
    IOrderService orderService;

    @RequestMapping("order")
    public String order(Model model){
        model.addAttribute("active","order");

        return "order";
    }

    @RequestMapping("getOrders")
    @ResponseBody
    public SystemPage getOrders(int start,int pageSize){
        int totals = 0;
        SystemPage page = new SystemPage();
        try {
            totals = orderService.getCount(null,null);
            List data = orderService.selectList(null,start,pageSize,null);
            page = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("getLogistics")
    @ResponseBody
    public Object getLogistics(int orderId){

        return null;
    }

    @RequestMapping("deliverGoods")
    @ResponseBody
    public Object deliverGoods(int orderId,String com,String no){

        return null;
    }

    @RequestMapping("receivingAddress")
    @ResponseBody
    public Object receivingAddress(int addrId){

        return null;
    }

    @RequestMapping("listOfGoods")
    @ResponseBody
    public Object listOfGoods(int addrId){

        return null;
    }
}
