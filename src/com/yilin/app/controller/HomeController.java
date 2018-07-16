package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.IUserInfoService;
import com.yilin.app.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {

    Map<String,User> userLoginMap = new HashMap<>();

    @Resource
    IUserInfoService userInfoService;

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
    @ResponseBody
    public ResultJson UserLogin(String loginName, String loginPwd) throws IOException
    {
        ResultJson result;
        User user = null;
        try {
            user = userInfoService.selectForLogin(loginName,loginPwd);
            result = new ResultJson(true,"登陆成功!"+"--"+loginName);
            String token = MD5Util.encrypt(user.getLoginName()+user.getLoginPwd()+System.currentTimeMillis());
            result.setObj(token);
            userLoginMap.put(token,user);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"登陆失败!"+"--"+loginName);
        }
        return result;
    }
}

