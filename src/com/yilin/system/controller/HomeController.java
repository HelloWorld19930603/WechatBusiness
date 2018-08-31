package com.yilin.system.controller;

import com.yilin.app.domain.SystemUser;
import com.yilin.system.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @RequestMapping("loginout")
    public String loginout(HttpServletRequest req){
        req.getSession().invalidate();
        return "login";
    }


    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("toLogin")
    @ResponseBody
    public Object toLogin(String loginName, String loginPwd, HttpServletRequest req){
        try {
            SystemUser user = systemUserService.selectForLogin(loginName,loginPwd);
            if(user != null) {
                user.setLoginTime(new Date());
                systemUserService.editOne(user);
                req.getSession().setAttribute("user", user);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
