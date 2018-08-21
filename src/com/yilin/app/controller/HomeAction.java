package com.yilin.app.controller;

import com.yilin.app.common.*;
import com.yilin.app.domain.User;
import com.yilin.app.exception.RequestException;
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
    public ResultJson messageCode(String phone,String token) {
        ResultJson result;
        try {
            UserInfo userInfo = Permission.getUserInfo(token);
            if(userInfo.getMessage_code() != null && (System.currentTimeMillis() - userInfo.getMessage_time() < 60000) ){
                return new ResultJson(false,"短信发送间隔60秒/次，请稍后尝试！");
            }
            String code = JuHeMessage.createCode();
            JuHeMessage.getRequest2(phone,"#code#="+code, Configuration.MESSAGE_MODEL);
            result = new ResultJson(true,"发送成功!");
            userInfo.setMessage_code(code);
            userInfo.setMessage_time(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"发送失败!");
        }
        return result;
    }

    @RequestMapping(value="logistics")
    @ResponseBody
    public ResultJson logistics(String com,String no) {
        ResultJson result;
        try {
            Object logistics = JuHelogistics.getRequest1(com,no);
            result = new ResultJson(true,"查询成功!",logistics);
        }catch (RequestException re){
            result = new ResultJson(false,"查询失败!",re.getMsg());
        }catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询失败!");
        }
        return result;
    }

    @RequestMapping("isLogin")
    @ResponseBody
    public ResultJson isLogin(String token) {
        ResultJson result;
        boolean isLogin = false;
        try {
            isLogin = Permission.getUserInfo(token)==null?false:true;
            result = new ResultJson(true, "查询成功",isLogin);
        } catch (Exception e) {
            result = new ResultJson(false, "查询失败",isLogin);
            e.printStackTrace();
        }
        return result;
    }
}

