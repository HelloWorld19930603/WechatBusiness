package com.yilin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2018/8/19.
 */
@Controller
public class CommodityController {

    @RequestMapping("commodity")
    public String commodity(Model model){
        model.addAttribute("active","commodity");

        return "commodity";
    }

    @RequestMapping("addCommodity")
    public String addCommodity(Model model){
        model.addAttribute("active","addCommodity");

        return "addCommodity";
    }
}
