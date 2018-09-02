package com.yilin.system.controller;

import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IAgentUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
@Controller
public class AgentUpgradeAuditController {


    @Autowired
    IAgentUpgradeService agentUpgradeService;

    @RequestMapping("/agentUpgrade")
    public String agentAudit(Model model){
        model.addAttribute("active","agentUpgrade");
        return "agentUpgrade";
    }


    @RequestMapping("getAgentUpgradeAudits")
    @ResponseBody
    public SystemPage getAgentAudits(Byte status,Byte serise,String phone,String name,int start,int pageSize){
        int totals = 0;
        SystemPage systemPage = null;
        try {
            totals = agentUpgradeService.getCount(status,serise,phone,name);
            List<Map<String, Object>> data = agentUpgradeService.selectList(status,serise,phone,name,start,pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }


    @RequestMapping("decideAgentUpgrade")
    @ResponseBody
    public String decideAgent(int id,byte status,int userId,int level,int serise) throws Exception {
        agentUpgradeService.audit(id,status,userId,level,serise);
        return "0";
    }



}
