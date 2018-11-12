package com.yilin.system.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.DataTmp;
import com.yilin.app.domain.SystemLog;
import com.yilin.app.domain.SystemUser;
import com.yilin.app.service.ISystemLogService;
import com.yilin.app.utils.MD5Util;
import com.yilin.system.service.IDataTmpService;
import com.yilin.system.service.IHomeService;
import com.yilin.system.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/10.
 */
@Controller
public class HomeController {

    @Autowired
    ISystemUserService systemUserService;
    @Autowired
    IHomeService homeService;
    @Autowired
    ISystemLogService systemLogService;
    @Autowired
    IDataTmpService dataTmpService;

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("active", "index");
        return "index";
    }

    @RequestMapping("loginout")
    public String loginout(HttpServletRequest req) {
        SystemUser user = (SystemUser) req.getSession().getAttribute("user");
        req.getSession().invalidate();
        if (user != null)
            systemLogService.log(new SystemLog("用户" + user.getName() + "退出了管理系统", 2, user.getLoginName()));
        return "redirect:/login.html";
    }

    @RequestMapping("modifyPwd")
    public String modifyPwd() {
        return "modifyPwd";
    }

    @RequestMapping("toModifyPwd")
    @ResponseBody
    public Integer toModifyPwd(HttpServletRequest req, String newPwd) {

        SystemUser user = (SystemUser) req.getSession().getAttribute("user");
        try {
            user.setLoginPwd(MD5Util.encrypt(newPwd));
            systemUserService.editOne(user);
            systemLogService.log(new SystemLog("用户" + user.getName() + "修改了管理系统登录密码", 3, user.getLoginName()));
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @RequestMapping("login")
    public String login() {
        return "redirect:/login.html";
    }

    @RequestMapping("toLogin")
    @ResponseBody
    public Object toLogin(String loginName, String loginPwd, HttpServletRequest req) {
/*        if(loginName == null || "".equals(loginName.trim())){
            req.getSession().setAttribute("user", new SystemUser());
            return 0;
        }*/
        try {
            SystemUser user = systemUserService.selectForLogin(loginName, loginPwd);
            if (user != null) {
                req.getSession().setAttribute("lastTime", user.getLoginTime());
                user.setLoginTime(new Date());
                systemUserService.editOne(user);
                req.getSession().setAttribute("user", user);
                systemLogService.log(new SystemLog("用户" + user.getName() + "登录管理系统", 1, user.getLoginName()));
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }


    @RequestMapping("table")
    public String table(Model model) {
        model.addAttribute("active", "test");
        return "table";
    }

    @RequestMapping("form")
    public String form(Model model) {
        model.addAttribute("active", "test2");
        return "form";
    }


    @RequestMapping("invitingAgent")
    public String invitingAgent(int inviting, String invitationName, String applyName, byte serise, int level, Model model) {
        model.addAttribute("inviting", inviting);
        model.addAttribute("invitationName", invitationName);
        model.addAttribute("applyName", applyName);
        model.addAttribute("serise", serise);
        model.addAttribute("level", level);
        return "invitingAgent";
    }


    @RequestMapping("selectAll")
    @ResponseBody
    public ResultJson selectAll(String start, String end) {
        Integer[] obj = homeService.selectAll(start, end);
        ResultJson result = new ResultJson(true, "success", obj);
        return result;
    }

    @RequestMapping("selectForSale")
    @ResponseBody
    public ResultJson selectForSale(String start, String end) {
        List<Map<String, Object>> obj = homeService.selectForSale(start, end);
        ResultJson result = new ResultJson(true, "success", obj);
        return result;
    }

    @RequestMapping("selectForDealer")
    @ResponseBody
    public ResultJson selectForDealer(String start, String end) {
        List<Map<String, Object>> obj = homeService.selectForDealer(start, end);
        ResultJson result = new ResultJson(true, "success", obj);
        return result;
    }



    @RequestMapping("dataTmp")
    @ResponseBody
    public ResultJson dataTmp(Long time) throws Exception {
        List<DataTmp> obj = dataTmpService.selectList(1,time);
        ResultJson result = new ResultJson(true, "success", obj);
        for(DataTmp tmp : obj){
            tmp.setStatus(0);
            dataTmpService.updateOne(tmp);
        }
        return result;
    }
}
