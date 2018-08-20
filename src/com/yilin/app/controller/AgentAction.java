package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.AgentUpgrade;
import com.yilin.app.service.IAgentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("agent")
public class AgentAction {

    @Resource
    IAgentService agentService;

    /**
     * 代理升级
     *
     * @param agentUpgrade
     * @return
     */
    @RequestMapping("upgrade")
    @ResponseBody
    public ResultJson upgrade(AgentUpgrade agentUpgrade,String token) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            agentUpgrade.setUserId(userId);
            agentService.addUpgrade(agentUpgrade);
            result = new ResultJson(true, "提交申请成功");
        } catch (Exception e) {
            result = new ResultJson(false, "提交申请失败");
            e.printStackTrace();
        }
        return result;
    }

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
            Integer userId = Permission.getUserId(token);
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
     * @param start
     * @param pageSize
     * @return
     */
    @RequestMapping("findPrice")
    @ResponseBody
    public ResultJson findPrice(String token, int start, int pageSize) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            result = new ResultJson(true, "成功");
        } catch (Exception e) {
            result = new ResultJson(false, "失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("invitingAgent")
    @ResponseBody
    public ResultJson invitingAgent(String token) {
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            String url = "http://www.twrzu.cn/invitingAgent.do?inviting="+userId;
            result = new ResultJson(true, "成功",url);
        } catch (Exception e) {
            result = new ResultJson(false, "失败");
            e.printStackTrace();
        }
        return result;
    }
}
