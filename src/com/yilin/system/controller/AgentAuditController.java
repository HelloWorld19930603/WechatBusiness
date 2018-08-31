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


    @RequestMapping("/agent")
    public String agentAudit(Model model){
        model.addAttribute("active","agent");
        return "agent";
    }


    @RequestMapping("getAgentAudits")
    @ResponseBody
    public SystemPage getAgentAudits(Byte status,Byte serise,String currentLevel,String phone,String name){
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
