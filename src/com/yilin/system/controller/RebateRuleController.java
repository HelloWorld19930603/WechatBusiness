package com.yilin.system.controller;

import com.yilin.app.domain.RebateRule;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IRebateRuleService;
import com.yilin.system.service.IRebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cc on 2018/8/26.
 */
@Controller
public class RebateRuleController {

    @Autowired
    IRebateRuleService rebateRuleService;

    @RequestMapping("rebateRule")
    public String rebateRule(Model model) {
        model.addAttribute("active", "rebateRule");
        return "rebateRule";
    }

    @RequestMapping("addRebateRule")
    public String addRebateRule(Model model) {
        model.addAttribute("active", "addRebateRule");
        return "addRebateRule";
    }

    @RequestMapping("addRebateRule2")
    @ResponseBody
    public Integer addRebateRule2(RebateRule rebateRule) throws Exception {
        rebateRuleService.addOne(rebateRule);
        return 0;
    }

    @RequestMapping("getRebateRules")
    @ResponseBody
    public SystemPage getRebateRules(Model model, String name, Byte serise, int start, int pageSize) throws Exception {
        serise = serise == -1 ? null : serise;
        int totals = rebateRuleService.getCount(name, serise);
        List data = rebateRuleService.selectList(name, serise, start, pageSize);
        SystemPage systemPage = new SystemPage(totals, data);
        return systemPage;
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
