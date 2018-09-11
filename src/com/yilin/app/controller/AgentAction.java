package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.common.UserInfo;
import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.domain.UserRole;
import com.yilin.app.exception.FileException;
import com.yilin.app.service.IAgentService;
import com.yilin.app.service.IRoleService;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.system.service.IAgentUpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("agent")
public class AgentAction {

    @Resource
    IAgentService agentService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IAgentUpgradeService agentUpgradeService;



    /**
     * 获取当前用户级别
     *
     * @param token
     * @param serise
     * @return
     */
    @RequestMapping("findLevel")
    @ResponseBody
    public ResultJson findLevel(String token, byte serise) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            int level = agentService.findLevel(userId,serise);
            result = new ResultJson(true, "查询代理等级成功",level);
        } catch (Exception e) {
            result = new ResultJson(false, "查询代理等级失败");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 查询订货价
     *
     * @param token

     * @return
     */
    @RequestMapping("findPrice")
    @ResponseBody
    public ResultJson findPrice(String token) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            List<UserRole> list = roleService.selectRoles(userId);
            Map<Integer,String> map = new HashMap<>();
            String[] agent = {"glt","ut","ps"};
            for(UserRole userRole : list){
                map.put(userRole.getSerise(),"/images/home/agent/"+agent[userRole.getSerise()-1]+"/"+userRole.getRoleId()+".jpg");
            }
            result = new ResultJson(true, "查询订货价成功",map);
        } catch (Exception e) {
            result = new ResultJson(false, "查询订货价失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("invitingAgent")
    @ResponseBody
    public ResultJson invitingAgent(String token,String name,byte serise,int level) {
        ResultJson result;
        try {
            UserInfo userInfo = Permission.getUserInfo(token);
            String url = "http://www.twrzu.cn/invitingAgent.do?inviting="+userInfo.getId()
                    +"&invitationName="+userInfo.getName()+"&applyName="+name+"&serise="+serise+"&level="+level;
            result = new ResultJson(true, "成功",url);
        } catch (Exception e) {
            result = new ResultJson(false, "失败");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("upgrade")
    @ResponseBody
    public ResultJson upgrade(String token,String name, byte serise, int applyLev, int currentLev,
                                 String description, @RequestParam(value = "voucher", required = false) MultipartFile voucher,
                                 HttpServletRequest req) {
        int userId = Permission.getUserId(token);
        AgentUpgrade agentUpgrade = new AgentUpgrade();
        agentUpgrade.setUserId(userId);
        agentUpgrade.setName(name);
        agentUpgrade.setApplyLevel(applyLev);
        agentUpgrade.setSerise(serise);
        agentUpgrade.setStatus((byte)0);
        agentUpgrade.setCurrentLevel(currentLev);
        agentUpgrade.setTime(new Date());
        String url = null;
        ResultJson result = new ResultJson(true, "成功");
        try {
            url = PhotoUtil.photoUpload(voucher,"images/home/voucher/recharge/",""+userId+System.currentTimeMillis(),req.getSession().getServletContext().getRealPath("/"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileException e) {
            e.printStackTrace();
            result = new ResultJson(false, "失败");
        }
        agentUpgrade.setDescript(description);
        agentUpgrade.setVoucher(url);
        try {
            agentUpgradeService.addOne(agentUpgrade);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "失败");
        }
        return result;
    }
}
