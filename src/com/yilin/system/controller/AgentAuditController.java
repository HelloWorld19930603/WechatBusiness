package com.yilin.system.controller;

import com.yilin.app.common.Configuration;
import com.yilin.app.common.JuHeMessage;
import com.yilin.app.domain.Agent;
import com.yilin.app.domain.User;
import com.yilin.app.domain.Wallet;
import com.yilin.app.exception.RequestException;
import com.yilin.app.service.IUserService;
import com.yilin.app.service.IWalletService;
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
import java.util.Date;
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
    @Autowired
    IWalletService walletService;

    @RequestMapping("/agent")
    public String agentAudit(Model model) {
        model.addAttribute("active", "agent");
        return "agent";
    }


    @RequestMapping("getAgentAudits")
    @ResponseBody
    public SystemPage getAgentAudits(Byte status, Byte serise, String phone, String name, int start, int pageSize) {
        int totals = 0;
        SystemPage systemPage = null;
        try {
            serise = serise == -1 ? null : serise;
            totals = agentAuditService.getCount(status, serise, phone, name);
            List<Map<String, Object>> data = agentAuditService.selectList(status, serise, phone, name, start, pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }


    @RequestMapping("decideAgent")
    @ResponseBody
    public Integer decideAgent(int id, byte status, int userId) {
        try {
            agentAuditService.audit(id, status, userId);
        }catch (RequestException re){
            re.printStackTrace();
            return 2;
        }catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @RequestMapping("applyAgent")
    @ResponseBody
    public String applyAgent(int userId, String applyName, byte serise, int level, String phone, String wxNum,
                              String idNum, String description, @RequestParam(value = "file", required = false) MultipartFile file,
                              HttpServletRequest req) {
        User user = new User();
        user.setName(applyName);
        user.setLoginName(phone);
        user.setPhone(phone);
        user.setWxNum(wxNum);
        user.setIdNum(idNum);
        user.setLoginPwd(Configuration.LOGIN_PWD_DEFAULT);
        user.setPayPwd(Configuration.PAY_PWD_DEFAULT);
        user.setSupId(userId);
        user.setStatus((byte) 0);
        Agent agent = new Agent();
        agent.setApplyLevel(level);
        agent.setSerise(serise);
        agent.setName(applyName);
        agent.setDescription(description);
        agent.setStatus((byte) 1);
        agent.setTime(new Date());

        try {
            if (file != null) {
                String path = PhotoUtil.photoUpload(file, "images/home/voucher/agent/", StringUtil.makeFileName(),
                        req.getSession().getServletContext().getRealPath("/"));
                agent.setVoucher(path);
            }
            userService.register(user);
            agent.setUserId(user.getId());
            agent.setInviter(userId);
            Wallet wallet = new Wallet();
            wallet.setMoney((float)0);
            wallet.setUserId(user.getId());
            wallet.setSerise(serise);
            agentAuditService.addOne(agent);
            walletService.addWallet(wallet);
        } catch (Exception e) {
            e.printStackTrace();
            return "提交失败！";
        }
        return "提交成功！";
    }

}
