package com.yilin.system.controller;

import com.yilin.system.common.SystemPage;
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
public class RebateController {

    @Autowired
    IRebateService rebateService;

    @RequestMapping("rebate")
    public String rebate(Model model) {
        model.addAttribute("active", "rebate");
        return "rebate";
    }

    @RequestMapping("addRebate")
    public String addRebate(Model model) {
        model.addAttribute("active", "addRebate");
        return "addRebate";
    }

    @RequestMapping("getRebates")
    @ResponseBody
    public Integer getRebates(Model model, String name, Byte serise, int start, int pageSeize) throws Exception {
        model.addAttribute("active", "rebate");
        serise = serise == -1 ? null : serise;
        int totals = rebateService.selectCount(name, serise);
        List data = rebateService.selectList(name, serise, start, pageSeize);
        SystemPage systemPage = new SystemPage(totals, data);
        return 0;
    }
}
