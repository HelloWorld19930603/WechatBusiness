package com.yilin.system.controller;

import com.yilin.app.domain.Agent;
import com.yilin.app.domain.User;
import com.yilin.app.service.IUserService;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IAgentAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
@Controller
public class AgentAuditController {


    @Autowired
    IAgentAuditService agentAuditService;
    @Autowired
    IUserService userService;

    @RequestMapping("/agent")
    public String agentAudit(Model model){
        model.addAttribute("active","agent");
        return "agent";
    }


    @RequestMapping("getAgentAudits")
    @ResponseBody
    public SystemPage getAgentAudits(Byte status,Byte serise,String phone,String name,int start,int pageSize){
        int totals = 0;
        SystemPage systemPage = null;
        try {
            totals = agentAuditService.getCount(status,serise,phone,name);
            List<Map<String, Object>> data = agentAuditService.selectList(status,serise,phone,name,start,pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }


    @RequestMapping("decideAgent")
    @ResponseBody
    public Integer decideAgent(int id,byte status,int userId) throws Exception {
            agentAuditService.audit(id,status,userId);
        return 0;
    }

    @RequestMapping("applyAgent")
    @ResponseBody
    public Integer applyAgent(int userId, String applyName, byte serise, int level, String phone, String wxNum,
                              String idNum, String description, @RequestParam(value = "file", required = false) MultipartFile file,
                              HttpServletRequest req){
        User user = new User();
        user.setName(applyName);
        user.setLoginName(phone);
        user.setPhone(phone);
        user.setWxNum(wxNum);
        user.setIdNum(idNum);
        user.setLoginPwd("123456");
        user.setPayPwd("123456");
        user.setSupId(userId);
        user.setStatus((byte)0);
        Agent agent = new Agent();
        agent.setApplyLevel(level);
        agent.setSerise(serise);
        agent.setName(applyName);
        agent.setDescription(description);
        agent.setStatus((byte)0);
        try {
            if(file != null) {
                String path = PhotoUtil.photoUpload(file, "images/home/voucher/agent/", StringUtil.makeFileName(),
                        req.getSession().getServletContext().getRealPath("/"));
                agent.setVoucher(path);
            }
          userService.register(user);
          agent.setInviter(user.getId());
          agentAuditService.addOne(agent);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
