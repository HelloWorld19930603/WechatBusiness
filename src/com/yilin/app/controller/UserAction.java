package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.common.UserInfo;
import com.yilin.app.domain.User;
import com.yilin.app.exception.FileException;
import com.yilin.app.service.impl.UserService;
import com.yilin.app.utils.PhotoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by cc on 2018/7/13.
 */
@Controller
@RequestMapping("user")
public class UserAction {

    @Resource
    UserService userService;

/*    @RequestMapping("register")
    @ResponseBody
    public ResultJson register(User user) {
        ResultJson result;
        try {
            userService.register(user);
            result = new ResultJson(true, "注册成功");
        } catch (Exception e) {
            result = new ResultJson(false, "注册失败");
            e.printStackTrace();
        }
        return result;
    }*/

    @RequestMapping("updateUser")
    @ResponseBody
    public ResultJson updateUser(User user,String token) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            user.setId(userId);
            userService.updateUser(user);
            result = new ResultJson(true, "修改成功");
        } catch (Exception e) {
            result = new ResultJson(false, "修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("findUser")
    @ResponseBody
    public ResultJson findUser(String token) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            User user = userService.findUser(userId);
            result = new ResultJson(true, "查询成功", user);
        } catch (Exception e) {
            result = new ResultJson(false, "查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("getUser")
    @ResponseBody
    public ResultJson getUser(String token) {
        ResultJson result;
        try {
            UserInfo userInfo = Permission.getUserInfo(token);
            result = new ResultJson(true, "查询成功", userInfo);
        } catch (Exception e) {
            result = new ResultJson(false, "查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("loginPwd")
    @ResponseBody
    public ResultJson loginPwd(String token, String newPwd, String code) {
        ResultJson result;
        try {
            UserInfo userInfo = Permission.getUserInfo(token);
            if (userInfo.getMessage_code() != null && userInfo.getMessage_code().equals(code.trim())) {
                userService.updateLoginPwd(userInfo.getId(), newPwd);
                result = new ResultJson(true, "修改成功");
                userInfo.setMessage_code(null);
            } else {
                result = new ResultJson(false, "验证码错误");
            }
        } catch (Exception e) {
            result = new ResultJson(false, "修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("payPwd")
    @ResponseBody
    public ResultJson payPwd(String token,String newPwd, String code) {
        ResultJson result;
        try {
            UserInfo userInfo = Permission.getUserInfo(token);
            if (userInfo.getMessage_code() != null && userInfo.getMessage_code().equals(code.trim())) {
                userService.updatePayPwd(userInfo.getId(), newPwd);
                result = new ResultJson(true, "修改成功");
                userInfo.setMessage_code(null);
            } else {
                result = new ResultJson(false, "验证码错误");
            }
        } catch (Exception e) {
            result = new ResultJson(false, "修改失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updateHead")
    @ResponseBody
    public ResultJson updateHead(String token, @RequestParam MultipartFile headImg,
                                 HttpServletRequest req) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            String haedUrl = PhotoUtil.photoUpload(headImg, "images/home/head/" ,userId.toString(), req.getSession().getServletContext().getRealPath("/"));
            userService.updateHead(userId, haedUrl);
            result = new ResultJson(true, "上传成功");
        } catch (FileException e) {
            result = new ResultJson(false, "修改失败");
            e.printStackTrace();
        } catch (Exception e) {
            result = new ResultJson(false, "修改失败");
            e.printStackTrace();
        }
        return result;
    }



}
