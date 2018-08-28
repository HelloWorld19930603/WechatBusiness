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
public class AgentAuditController {


    @RequestMapping("/agent/agentAudit")
    public String agentAudit(Model model){
        model.addAttribute("active","agentAudit");
        return "agentAudit";
    }


    @RequestMapping("getAgentAudit")
    @ResponseBody
    public SystemPage getAgentAudits(){
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


    @RequestMapping("decideAgent")
    @ResponseBody
    public String decideAgent(int id,int status){

        return "";
    }

    @RequestMapping("applyAgent")
    @ResponseBody
    public String applyAgent(int id,int status){

        return "";
    }

}
