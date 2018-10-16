package com.yilin.system.controller;

import com.yilin.app.domain.Rebate;
import com.yilin.app.domain.RebateRule;
import com.yilin.app.domain.SystemLog;
import com.yilin.app.domain.SystemUser;
import com.yilin.app.service.ISystemLogService;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IRebateRuleService;
import com.yilin.system.service.IRebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cc on 2018/8/26.
 */
@Controller
public class RebateController {

    @Autowired
    IRebateRuleService rebateRuleService;
    @Autowired
    IRebateService rebateService;
    @Autowired
    ISystemLogService systemLogService;

    @RequestMapping("rebate1")
    public String rebate1(Model model) {
        model.addAttribute("active", "rebate1");
        model.addAttribute("serise", 1);
        return "rebate1";
    }

    @RequestMapping("rebate2")
    public String rebate2(Model model) {
        model.addAttribute("active", "rebate2");
        model.addAttribute("serise", 2);
        return "rebate2";
    }

    @RequestMapping("rebate3")
    public String rebate3(Model model) {
        model.addAttribute("active", "rebate3");
        model.addAttribute("serise", 3);
        return "rebate3";
    }

    @RequestMapping("addRebate")
    public String addRebateRule(Model model,int serise) {
        model.addAttribute("active", "rebate");
        model.addAttribute("serise", serise);
        return "addRebate";
    }

    @RequestMapping("addRebate2")
    @ResponseBody
    public Integer addRebate2(Rebate rebate, HttpServletRequest req) {
        try {
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            rebate.setOperator(user.getId());
            rebateService.addOne(rebate);
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+
                    rebate.getUserId()+"的用户进行了返利，其中返利金额为"+rebate.getMoney(), 11, user.getLoginName()));
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @RequestMapping("getRebates")
    @ResponseBody
    public SystemPage getRebatees(String name, Byte serise,Integer type, int start, int pageSize)  {
        serise = serise == -1 ? null : serise;
        int totals = 0;
        try {
            totals = rebateService.getCount(name, serise,type);
            List data = rebateService.selectList(name, serise,type, start, pageSize);
            SystemPage systemPage = new SystemPage(totals, data);
            return systemPage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("removeRebateRule")
    @ResponseBody
    public Integer removeRebateRule(int id) throws Exception {
        rebateRuleService.removeOne(id);
        return 0;
    }

    @RequestMapping("editRebateRule")
    @ResponseBody
    public Integer editRebateRule(RebateRule rebateRule) throws Exception {
        rebateRuleService.editOne(rebateRule);
        return 0;
    }
}
