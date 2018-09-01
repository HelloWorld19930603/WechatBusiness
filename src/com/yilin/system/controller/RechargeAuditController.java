package com.yilin.system.controller;

import com.yilin.app.domain.Recharge;
import com.yilin.app.domain.SystemUser;
import com.yilin.app.domain.Wallet;
import com.yilin.app.service.IWalletService;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IRechargeAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
@Controller
public class RechargeAuditController {

    @Autowired
    IRechargeAuditService rechargeAuditService;
    @Autowired
    IWalletService walletService;

    @RequestMapping("rechargeAudit")
    public String recharge(Model model){
        model.addAttribute("active","rechargeAudit");
        return "rechargeAudit";
    }


    @RequestMapping("getRechargeAudits")
    @ResponseBody
    public SystemPage getRechargeAudits(Byte status,Byte serise,String phone,String userId,int start,int pageSize){
        int totals = 0;
        SystemPage systemPage = null;
        try {
            if(serise == -1){
                serise = null;
            }
            totals = rechargeAuditService.getCount(status,serise,phone,userId);
            List<Map<String, Object>> data = rechargeAuditService.selectList(status,serise,phone,userId,start,pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }

    @RequestMapping("decideRecharge")
    @ResponseBody
    public Object decideRecharge(int id, Byte status, HttpServletRequest req)  {
        Recharge recharge = new Recharge();
        recharge.setId(id);
        recharge.setStatus(status);
        SystemUser user = (SystemUser) req.getSession().getAttribute("user");
        recharge.setAuditor(user.getId());
        try {
        if(status == 2){
            Recharge recharge2  = rechargeAuditService.selectOne(id);
            Float money = walletService.getMoney(recharge2.getUserId(),recharge2.getSerise());
            if(money == null){
                Wallet wallet = new Wallet();
                wallet.setSerise(recharge2.getSerise());
                wallet.setUserId(recharge2.getUserId());
                wallet.setMoney(recharge2.getMoney());
                walletService.addWallet(wallet);
            }else{
                walletService.addMoney(recharge2.getSerise(),recharge2.getUserId(),recharge2.getMoney());
            }
        }
        rechargeAuditService.editOne(recharge);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
