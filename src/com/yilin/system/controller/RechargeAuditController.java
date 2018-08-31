package com.yilin.system.controller;

import com.yilin.system.common.SystemPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
@Controller
public class RechargeAuditController {

    @RequestMapping("recharge")
    public String recharge(Model model){
        model.addAttribute("active","recharge");
        return "recharge";
    }


    @RequestMapping("getRechargeAudits")
    @ResponseBody
    public SystemPage getRechargeAudits(Byte status,Byte serise,String phone,String name){
        int totals = 0;
        SystemPage systemPage = null;
        try {
            List<Map<String, Object>> data = null;
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }

    @RequestMapping("decideRecharge")
    @ResponseBody
    public String decideRecharge(int id,int status){

        return "";
    }
}
