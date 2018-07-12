package com.yilin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/Home")
public class HomeController {


    @RequestMapping(value="index")
    public String Index()
    {

        return "index";
    }


    @RequestMapping(value="login")
    public String Login()
    {
        return "login";

    }

    @RequestMapping(value="userLogin")
    public String UserLogin(HttpServletRequest request, HttpServletResponse respnose, HttpSession httpSession) throws IOException
    {
        //登陆成功后，写入session
        String userName=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        System.out.println("登陆成功!"+"--"+userName);
        httpSession.setAttribute("username", userName);
        return "redirect:/Home/index.action";
    }
}

