package com.yilin.system.controller;

import com.yilin.app.domain.SystemUser;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cc on 2018/8/21.
 */
@Controller
public class SystemController {

    @Autowired
    ISystemUserService systemUserService;



    @RequestMapping("system")
    public String index(Model model){
        model.addAttribute("active","index");
        return "system";
    }

    @RequestMapping("addSystemUser")
    public String addSystemUser(Model model){
        model.addAttribute("active","index");
        return "addSystemUser";
    }


    @RequestMapping("addSystemUser2")
    @ResponseBody
    public Object addSystemUser2(SystemUser user){
        try {
            systemUserService.addOne(user);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }

    }


    @RequestMapping("editSystemUser2")
    @ResponseBody
    public Object editSystemUser2(SystemUser user){
        try {
            systemUserService.editOne(user);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }

    }

    @RequestMapping("editPwd")
    @ResponseBody
    public Object editPwd(int id,String oldPwd,String newPwd){
        try {
            systemUserService.editPwd(id,oldPwd,newPwd);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }

    }

    @RequestMapping("removeSystemUser")
    @ResponseBody
    public Object removeSystemUser(int id){
        try {
            systemUserService.deleteOne(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }

    }

    @RequestMapping("getSystemUsers")
    @ResponseBody
    public Object getSystemUsers(String name,String phone,String loginName,int start,int pageSize){
        try {
            int totals = systemUserService.selectCount(name,phone,loginName);
            List data = systemUserService.selectPage(name,phone,loginName,start,pageSize);
            SystemPage page = new SystemPage(totals,data);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemPage();
        }

    }
}
