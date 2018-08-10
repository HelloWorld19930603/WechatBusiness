package com.yilin.app.controller;

import com.yilin.app.common.JuHeMessage;
import com.yilin.app.common.JuHelogistics;
import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/home")
public class HomeAction {

    @Resource
    IUserService userService;

    @RequestMapping(value="index")
    public String index() {

        return "index";
    }


    @RequestMapping(value="login")
    public String login() {

        return "login";
    }

    @RequestMapping(value="userLogin")
    @ResponseBody
    public ResultJson userLogin(String loginName, String loginPwd) {
        ResultJson result;
        try {
            User user = userService.selectForLogin(loginName,loginPwd);
            if(user != null) {
                result = new ResultJson(true, "登陆成功!");
                result.setObj(Permission.createToken(user));
            }else {
                result = new ResultJson(false, "账号或密码错误!" );
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"登陆失败!");
        }
        return result;
    }

    @RequestMapping(value="loginout")
    @ResponseBody
    public ResultJson loginout(String token) {
        ResultJson result;
        try {
            Permission.cancel(token);
            result = new ResultJson(true,"注销成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"注销失败!");
        }
        return result;
    }

    @RequestMapping(value="messageCode")
    @ResponseBody
    public ResultJson messageCode(String phone) {
        ResultJson result;
        try {
            JuHeMessage.getRequest2(phone);
            result = new ResultJson(true,"发送成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"发送失败!");
        }
        return result;
    }

    @RequestMapping(value="logistics")
    @ResponseBody
    public ResultJson logistics(String phone) {
        ResultJson result;
        try {
            JuHelogistics.getRequest2();
            result = new ResultJson(true,"发送成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"发送失败!");
        }
        return result;
    }
}

