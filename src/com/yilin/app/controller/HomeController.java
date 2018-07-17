package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    IUserService userService;

    @RequestMapping(value="index")
    public String Index() {

        return "index";
    }


    @RequestMapping(value="login")
    public String Login() {

        return "login";
    }

    @RequestMapping(value="userLogin")
    @ResponseBody
    public ResultJson userLogin(String loginName, String loginPwd) {
        ResultJson result;
        User user;
        try {
            user = userService.selectForLogin(loginName,loginPwd);
            result = new ResultJson(true,"登陆成功!"+"--"+loginName);
            result.setObj(Permission.keepUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"登陆失败!"+"--"+loginName);
        }
        return result;
    }
}

