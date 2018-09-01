package com.yilin.system.controller;

import com.yilin.system.common.SystemPage;
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


    @RequestMapping("/agentUpgrade")
    public String agentAudit(Model model){
        model.addAttribute("active","agentUpgrade");
        return "agentUpgrade";
    }


    @RequestMapping("getAgentUpgradeAudits")
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


    @RequestMapping("decideAgentUpgrade")
    @ResponseBody
    public String decideAgent(int id,int status){

        return "";
    }

    @RequestMapping("applyAgentUpgrade")
    @ResponseBody
    public String applyAgent(int userId,String userName,String applyName,byte serise,int level,String phone,String wxNum,
                             @RequestParam(value = "file", required = false) MultipartFile file){

        return "....";
    }

}
