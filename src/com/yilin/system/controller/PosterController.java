package com.yilin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2018/8/7.
 */
@Controller
public class PosterController {


    @RequestMapping("poster")
    public String dealer1(Model model){
        model.addAttribute("active","poster");

        return "poster";
    }
}
