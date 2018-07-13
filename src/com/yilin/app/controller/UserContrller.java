package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/13.
 */
@Controller
@RequestMapping("userInfo")
public class UserContrller {


    @RequestMapping("register")
    @ResponseBody
    public ResultJson register(User user){

        ResultJson result = new ResultJson(true,"注册成功");
        return result;
    }
}
