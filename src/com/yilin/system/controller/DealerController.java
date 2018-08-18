package com.yilin.system.controller;

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

    @RequestMapping("dealer")
    public String index(Model model){
        model.addAttribute("active","dealer");

        return "dealer";
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



