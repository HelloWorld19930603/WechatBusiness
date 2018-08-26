package com.yilin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/8/26.
 */
@Controller
public class RebateController {



    @RequestMapping("rebate")
    public String rebate(Model model){
        model.addAttribute("active","rebate");
        return "rebate";
    }

    @RequestMapping("addRebate")
    public String addRebate(Model model){
        model.addAttribute("active","addRebate");
        return "addRebate";
    }

    @RequestMapping("getRebates")
    @ResponseBody
    public String getRebates(Model model){
        model.addAttribute("active","rebate");
        return "rebate";
    }
}
