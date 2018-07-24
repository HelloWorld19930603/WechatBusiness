package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/18.
 */
@Controller
@RequestMapping("wallet")
public class WalletController {

    @RequestMapping("payment")
    @ResponseBody
    public ResultJson payment(User user){
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
     *查询某系列账户余额
     * @param userId
     * @param serise
     * @return
     */
    @RequestMapping("findMoney")
    @ResponseBody
    public ResultJson findMoney(int userId,int serise){
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
     * 钱包充值
     * @param userId
     * @param serise
     * @param money
     * @param voucher
     * @return
     */
    @RequestMapping("addMoney")
    @ResponseBody
    public ResultJson addMoney(int userId,int serise,float money,String voucher){
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
     * 获取返利
     * @param userId
     * @param start
     * @param pageSize
     * @return
     */
    @RequestMapping("findRebate")
    @ResponseBody
    public ResultJson findRebate(int userId,int start,int pageSize){
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
