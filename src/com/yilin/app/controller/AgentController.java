package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.AgentUpgrade;
import org.apache.log4j.jmx.Agent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("agent")
public class AgentController {


    /**
     * 代理升级
     * @param agentUpgrade
     * @return
     */
    @RequestMapping("upgrade")
    @ResponseBody
    public ResultJson upgrade(AgentUpgrade agentUpgrade){
        ResultJson result;
        try {
            result = new ResultJson(true,"支付成功");
        } catch (Exception e) {
            result = new ResultJson(false,"支付失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取当前用户级别
     * @param userId
     * @param serise
     * @return
     */
    @RequestMapping("findLevel")
    @ResponseBody
    public ResultJson findLevel(int userId,int serise){
        ResultJson result;
        try {
            result = new ResultJson(true,"支付成功");
        } catch (Exception e) {
            result = new ResultJson(false,"支付失败");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 查询订货价
     * @param userId
     * @param start
     * @param pageSize
     * @return
     */
    @RequestMapping("findPrice")
    @ResponseBody
    public ResultJson findPrice(int userId,int start,int pageSize){
        ResultJson result;
        try {
            result = new ResultJson(true,"支付成功");
        } catch (Exception e) {
            result = new ResultJson(false,"支付失败");
            e.printStackTrace();
        }
        return result;
    }
}
