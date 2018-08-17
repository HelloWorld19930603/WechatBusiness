package com.yilin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2018/8/10.
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("active","index");
        return "index";
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
