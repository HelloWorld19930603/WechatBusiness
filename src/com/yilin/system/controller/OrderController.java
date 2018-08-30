package com.yilin.system.controller;

import com.yilin.app.common.JuHelogistics;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Address;
import com.yilin.app.domain.Logistics;
import com.yilin.app.exception.RequestException;
import com.yilin.app.service.IAddressService;
import com.yilin.app.service.IOrderService;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by cc on 2018/8/27.
 */
@Controller
public class OrderController {

    @Autowired
    IOrderService orderService;
    @Autowired
    IAddressService addressService;
    @Autowired
    ILogisticsService logisticsService;



    @RequestMapping("order")
    public String order(Model model){
        model.addAttribute("active","order");

        return "order";
    }

    @RequestMapping("getOrders")
    @ResponseBody
    public SystemPage getOrders(Integer userId,Byte status,Byte serise,int start,int pageSize){
        int totals = 0;
        SystemPage page = new SystemPage();
        try {
            totals = orderService.getCount(userId,status,serise);
            List data = orderService.selectList2(userId,status,serise,start,pageSize);
            page = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("getExpress")
    @ResponseBody
    public Object getExpress(){
        try {
            List list = logisticsService.findExpress();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("getLogistics")
    public Object getLogistics(String no,String com,Model model){
        try {
            Object logistics = JuHelogistics.getRequest1(com,no);
            model.addAttribute("logistics",logistics);
            return "logistics";
        }catch (Exception e) {
            e.printStackTrace();
            return "logistics";
        }
    }

    @RequestMapping("deliverGoods")
    public String deliverGoods(Model model,String orderId){
        model.addAttribute("active","order");
        model.addAttribute("orderId",orderId);
        return "addLogistics";
    }

    @RequestMapping("deliverGoods2")
    @ResponseBody
    public Object deliverGoods2(String orderId,String com,String no,String name){
        Logistics logistics = new Logistics();
        logistics.setId(no);
        logistics.setCom(com);
        logistics.setName(name);
        logistics.setOrderId(orderId);
        logistics.setTime(new Date());
        try {
            logisticsService.addOne(logistics);
            orderService.updateStatus(orderId,null,3,2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("receivingAddress")
    public String receivingAddress(int addrId,Model model) throws Exception {
        Address address = addressService.findAddress(addrId);
        model.addAttribute("address",address);
        model.addAttribute("active","order");

        return "address";
    }

    @RequestMapping("listOfGoods")
    public Object listOfGoods(String orderId,Model model){
        try {
            List list = orderService.selectDetails(orderId);
            model.addAttribute("list",list);
            model.addAttribute("active","order");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listOfGoods";
    }
}
