package com.yilin.system.controller;

import com.yilin.app.domain.DataTmp;
import com.yilin.app.domain.User;
import com.yilin.app.domain.UserRole;
import com.yilin.app.domain.Wallet;
import com.yilin.app.service.IRoleService;
import com.yilin.app.service.IUserService;
import com.yilin.app.service.IWalletService;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IDataTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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
    @Autowired
    IWalletService walletService;
    @Autowired
    IDataTmpService dataTmpService;


    @RequestMapping("dealer1")
    public String dealer1(Model model){
        model.addAttribute("active","dealer1");
        model.addAttribute("serise","1");

        return "dealer1";
    }

    @RequestMapping("dealer2")
    public String dealer2(Model model){
        model.addAttribute("active","dealer2");
        model.addAttribute("serise","2");

        return "dealer2";
    }

    @RequestMapping("dealer3")
    public String dealer3(Model model){
        model.addAttribute("active","dealer3");
        model.addAttribute("serise","3");

        return "dealer3";
    }

    @RequestMapping("addDealer")
    public String addDealer(Model model,int serise){
        model.addAttribute("active","dealer"+serise);
        model.addAttribute("serise",serise);

        return "addDealer";
    }

    @RequestMapping("showTeam")
    public String showTeam(Model model, int serise, int userId, HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        model.addAttribute("active","dealer"+serise);
        model.addAttribute("serise",serise);
        List<Map<String,Object>> data = null;

        try {
            data = userService.selectTeam(serise,userId);
            if(data.size() > 0){
                model.addAttribute("userName",data.get(0).get("name"));
            }
            double totals = 0;
            for(Map map : data){
                Double money = (Double)map.get("money");
                totals += money != null?money:0;
                map.put("roleId",userService.switchRole(serise, (Integer) map.get("roleId")));
            }
            model.addAttribute("totals",totals);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("data",data);
        return "showTeam";
    }



    @RequestMapping(value = "addDealer2")
    @ResponseBody
    public Object addDealer2(User user,int roleId,int serise){
        int userId;
        try {
            User diskUser = userService.selectByLoginName(user.getLoginName());
            if(diskUser != null ){
                UserRole userRole = roleService.selectRole(diskUser.getId(),serise);
                if(userRole != null) {
                    return 2;
                }
                userId = diskUser.getId();
            }else {
                user.setStatus((byte)1);
                userService.register(user);
                userId=user.getId();
            }
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setSerise(serise);
            userRole.setUserId(userId);
            roleService.addOne(userRole);
            Wallet wallet = new Wallet();
            wallet.setSerise((byte)serise);
            wallet.setUserId(userId);
            wallet.setMoney(0f);
            try {
                walletService.addWallet(wallet);
                dataTmpService.addOne(new DataTmp(serise,1,String.valueOf(userId),1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public Object getUsers(String code,Byte serise,String phone,String name,Byte status, int start,int pageSize) throws Exception {
        int totals = userService.selectNumBySerise(code,serise,phone,name,status);
        List<Map<String,Object>> data = userService.selectBySerise(code,serise,phone, name,status,start,pageSize);
        SystemPage page = new SystemPage(totals,data);
        return page;
    }

    @RequestMapping("getUsersByRole")
    @ResponseBody
    public Object getUsers(Byte serise,int roleId,Byte status) throws Exception {
        List<Map<String,Object>> data = userService.selectByRole(serise,roleId,status);
        return data;
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



