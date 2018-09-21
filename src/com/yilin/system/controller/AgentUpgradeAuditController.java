package com.yilin.system.controller;

import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.domain.SystemUser;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IAgentUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    public String agentAudit(Model model) {
        model.addAttribute("active", "agentUpgrade");
        return "agentUpgrade";
    }


    @RequestMapping("getAgentUpgradeAudits")
    @ResponseBody
    public SystemPage getAgentAudits(Byte status, Byte serise, String phone, String name, int start, int pageSize) {
        int totals = 0;
        SystemPage systemPage = null;
        try {
            if (serise != null)
                serise = serise == -1 ? null : serise;
            totals = agentUpgradeService.getCount(status, serise, phone, name);
            List<Map<String, Object>> data = agentUpgradeService.selectList(status, serise, phone, name, start, pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }


    @RequestMapping("decideAgentUpgrade")
    @ResponseBody
    public Object decideAgent(int id, byte status, int userId, int level, int serise, HttpServletRequest req)  {
        try {
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            if(user == null){
                return 2;
            }
            agentUpgradeService.audit(id, status, userId, level, serise,user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @RequestMapping("upgradeAgent")
    @ResponseBody
    public Object upgradeAgent(int userId, String applyName, byte serise, int applyLevel, int currentLevel,
                               @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) {

        AgentUpgrade agent = new AgentUpgrade();
        agent.setApplyLevel(applyLevel);
        agent.setCurrentLevel(currentLevel);
        agent.setSerise(serise);
        agent.setName(applyName);
        agent.setStatus((byte) 0);
        agent.setTime(new Date());
        agent.setUserId(userId);
        try {
            if (file != null) {
                String path = PhotoUtil.photoUpload(file, "images/home/voucher/agentUpgrade/", StringUtil.makeFileName(),
                        req.getSession().getServletContext().getRealPath("/"));
                agent.setVoucher(path);
            }
            agentUpgradeService.addOne(agent);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
