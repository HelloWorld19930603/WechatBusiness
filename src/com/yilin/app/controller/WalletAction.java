package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.User;
import com.yilin.app.service.IWalletService;
import com.yilin.app.utils.PhotoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by cc on 2018/7/18.
 */
@Controller
@RequestMapping("wallet")
public class WalletAction {

    @Resource
    IWalletService walletService;


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
    public ResultJson findMoney(int userId,byte serise){
        ResultJson result;
        try {
            float money = walletService.getMoney(userId,serise);
            result = new ResultJson(true,"查询成功",money);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
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
    public ResultJson addMoney(int userId, int serise, float money, @RequestParam MultipartFile voucher,
                               HttpServletRequest req){
        ResultJson result;
        try {
            PhotoUtil.photoUpload(voucher,"/voucher/"+userId,req);
            result = new ResultJson(true,"充值成功");
        } catch (Exception e) {
            result = new ResultJson(false,"充值失败");
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
            Page page = walletService.getRebate(userId,start,pageSize);
            result = new ResultJson(true,"查询成功",page);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("findRecharge")
    @ResponseBody
    public ResultJson findRecharge(int userId,byte serise,int start,int pageSize){
        ResultJson result;
        try {
            Page page = walletService.findRechargePage(userId,serise,start,pageSize);
            result = new ResultJson(true,"查询成功",page);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }



}
