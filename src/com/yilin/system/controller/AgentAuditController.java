package com.yilin.system.controller;

import com.yilin.app.common.Configuration;
import com.yilin.app.domain.*;
import com.yilin.app.exception.RequestException;
import com.yilin.app.service.ISystemLogService;
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
    @Autowired
    ISystemLogService systemLogService;

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
    public Integer decideAgent(int id, byte status, int userId,String remark,int serise, HttpServletRequest req) {
        try {
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            if(user == null){
                return 2;
            }
            agentAuditService.audit(id, status, userId,user.getId(),remark,serise);
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+userId+
                    "的用户进行了代理审核，其中审核结果为"+(status==2?"通过":"拒绝"), 8, user.getLoginName()));
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
    public Integer applyAgent(int userId, String applyName, byte serise, int level, String phone, String wxNum,
                              String idNum, String description, @RequestParam(value = "file", required = false) MultipartFile file,
                              HttpServletRequest req) {
        User user = new User();
        user.setName(applyName);
        user.setLoginName(phone);
        user.setPhone(phone);
        user.setWxNum(wxNum);
        user.setIdNum(idNum);
        user.setLoginPwd(Configuration.LOGIN_PWD_DEFAULT);
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
            return 1;
        }
        return 0;
    }

}
