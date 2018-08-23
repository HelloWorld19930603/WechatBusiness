package com.yilin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2018/8/21.
 */
@Controller
public class SystemController {

    @RequestMapping("invitingAgent")
    public String invitingAgent(int inviting,String invitationName,String applyName,byte serise,int level,Model model){
        model.addAttribute("inviting",inviting);
        model.addAttribute("invitationName",invitationName);
        model.addAttribute("applyName",applyName);
        model.addAttribute("serise",serise);
        model.addAttribute("level",level);
        return "invitingAgent";
    }
}
