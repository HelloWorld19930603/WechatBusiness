package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/13.
 */
@Controller
@RequestMapping("user")
public class UserContrller {

    @Resource
    UserService userService;

    @RequestMapping("register")
    @ResponseBody
    public ResultJson register(User user){
        ResultJson result;
        try {
            userService.register(user);
            result = new ResultJson(true,"注册成功");
        } catch (Exception e) {
            result = new ResultJson(false,"注册失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public ResultJson updateUser(User user){
        ResultJson result;
        try {
            userService.updateUser(user);
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("findUser")
    @ResponseBody
    public ResultJson findUser(int userId){
        ResultJson result;
        try {
            User user = userService.findUser(userId);
            result = new ResultJson(true,"查询成功",user);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("getUser")
    @ResponseBody
    public ResultJson getUser(String token){
        ResultJson result;
        try {
            User user = Permission.getToken(token);
            result = new ResultJson(true,"查询成功",user);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("loginPwd")
    @ResponseBody
    public ResultJson loginPwd(int userId,String oldPwd,String newPwd){
        ResultJson result;
        try {
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("payPwd")
    @ResponseBody
    public ResultJson payPwd(int userId,String oldPwd,String newPwd){
        ResultJson result;
        try {
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updateHead")
    @ResponseBody
    public ResultJson updateHead(int userId,String headImg){
        ResultJson result;
        try {
            result = new ResultJson(true,"修改成功");
        } catch (Exception e) {
            result = new ResultJson(false,"修改失败");
            e.printStackTrace();
        }
        return result;
    }
}
