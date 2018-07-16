package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cc on 2018/7/11.
 */
@Controller
public class LoginController {


    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ResultJson login(User user, HttpServletRequest request) {
        String string = request.getRemoteHost().toString();
        ResultJson j = new ResultJson();
        String login ;//= userService.login(user.getLoginname(), user.getPassword(), string, null);
        if ("success".equals("")) {
            j.setStatus(true);
            j.setMsg("登陆成功！");
        } else {
            j.setMsg("");
        }
        return j;
    }

    @ResponseBody
    @RequestMapping("/logout.do")
    public ResultJson logout() {
        ResultJson j = new ResultJson();
        //SecurityUtils.getSubject().logout();
        j.setStatus(true);
        j.setMsg("注销成功！");
        return j;
    }
}
