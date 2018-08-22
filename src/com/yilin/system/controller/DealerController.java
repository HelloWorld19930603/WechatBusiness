package com.yilin.system.controller;

import com.yilin.app.domain.User;
import com.yilin.app.service.IUserService;
import com.yilin.system.common.SystemPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/7.
 */
@Controller
public class DealerController {

    @Autowired
    IUserService userService;

    @RequestMapping("dealer1")
    public String dealer1(Model model){
        model.addAttribute("active","dealer1");

        return "dealer1";
    }

    @RequestMapping("dealer2")
    public String dealer2(Model model){
        model.addAttribute("active","dealer2");

        return "dealer2";
    }

    @RequestMapping("dealer3")
    public String dealer3(Model model){
        model.addAttribute("active","dealer3");

        return "dealer3";
    }

    @RequestMapping("addDealer")
    public String addDealer(Model model,int serise){
        model.addAttribute("active","dealer"+serise);
        model.addAttribute("serise",serise);

        return "addDealer";
    }

    @RequestMapping("addOne")
    @ResponseBody
    public Object addOne(Model model,int serise,User user){
        model.addAttribute("active","dealer"+serise);
        model.addAttribute("serise",serise);
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public Object getUsers(byte serise,int start,int pageSize){
        int totals = userService.selectNumBySerise(serise);
        List<Map<String,Object>> data = userService.selectBySerise(serise,start,pageSize);
        SystemPage page = new SystemPage(totals,data);
        return page;
    }
}



