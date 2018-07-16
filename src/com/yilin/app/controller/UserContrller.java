package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.impl.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/13.
 */
@Controller
@RequestMapping("userInfo")
public class UserContrller {

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("register")
    @ResponseBody
    public ResultJson register(User user){
        ResultJson result;
        try {
            userInfoService.register(user);
            result = new ResultJson(true,"注册成功");
        } catch (Exception e) {
            result = new ResultJson(false,"注册失败");
            e.printStackTrace();
        }
        return result;
    }
}
