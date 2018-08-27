package com.yilin.system.controller;

import com.yilin.system.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2018/8/10.
 */
@Controller
public class HomeController {

    @Autowired
    ISystemUserService systemUserService;

    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("active","index");
        return "system";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("table")
    public String table(Model model){
        model.addAttribute("active","test");
        return "table";
    }

    @RequestMapping("form")
    public String form(Model model){
        model.addAttribute("active","test2");
        return "form";
    }


}
