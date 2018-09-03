package com.yilin.system.controller;

import com.yilin.app.domain.User;
import com.yilin.app.domain.UserRole;
import com.yilin.app.service.IRoleService;
import com.yilin.app.service.IUserService;
import com.yilin.system.common.SystemPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/7.
 */
@Controller
public class DealerController {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;


    @RequestMapping("dealer1")
    public String dealer1(Model model){
        model.addAttribute("active","dealer1");

        return "dealer1";
    }

    @RequestMapping("dealer2")
    public String dealer2(Model model){
        model.addAttribute("active","dealer2");

        return "dealer2";
    }

    @RequestMapping("dealer3")
    public String dealer3(Model model){
        model.addAttribute("active","dealer3");

        return "dealer3";
    }

    @RequestMapping("addDealer")
    public String addDealer(Model model,int serise){
        model.addAttribute("active","dealer"+serise);
        model.addAttribute("serise",serise);

        return "addDealer";
    }

    @RequestMapping(value = "addDealer2")
    @ResponseBody
    public Object addDealer2(User user,int roleId,int serise){

        try {
            User diskUser = userService.selectByLoginName(user.getLoginName());
            if(diskUser != null ){
                return 2;
            }
            userService.register(user);
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setSerise(serise);
            userRole.setUserId(user.getId());
            roleService.addOne(userRole);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public Object getUsers(Byte serise,String phone,String name,Byte status, int start,int pageSize) throws Exception {
        int totals = userService.selectNumBySerise(serise,phone,name,status);
        List<Map<String,Object>> data = userService.selectBySerise(serise,phone, name,status,start,pageSize);
        SystemPage page = new SystemPage(totals,data);
        return page;
    }


    @RequestMapping("updateStatus")
    @ResponseBody
    public Object updateStatus(int id,byte status) {

        User user = new User();
        user.setId(id);
        user.setStatus(status);
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}



