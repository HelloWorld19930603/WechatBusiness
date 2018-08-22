package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.Permission;
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
import java.util.List;
import java.util.Map;

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
    public ResultJson payment(User user,String token){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            result = new ResultJson(true,"支付成功");
        } catch (Exception e) {
            result = new ResultJson(false,"支付失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *查询某系列账户余额
     * @param token
     * @param serise
     * @return
     */
    @RequestMapping("findMoney")
    @ResponseBody
    public ResultJson findMoney(String token,byte serise){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            float money = walletService.getMoney(userId,serise);
            result = new ResultJson(true,"查询成功",money);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("findAllMoney")
    @ResponseBody
    public ResultJson findAllMoney(String token){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            result = new ResultJson(true,"查询成功",walletService.getAllMoney(userId,(byte)1));
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 钱包充值
     * @param token
     * @param serise
     * @param money
     * @param voucher
     * @return
     */
    @RequestMapping("addMoney")
    @ResponseBody
    public ResultJson addMoney(String token, int serise, float money, @RequestParam MultipartFile voucher,
                               HttpServletRequest req){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            PhotoUtil.photoUpload(voucher,"/voucher/",userId.toString(),req.getSession().getServletContext().getRealPath("/"));
            result = new ResultJson(true,"充值成功");
        } catch (Exception e) {
            result = new ResultJson(false,"充值失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取返利
     * @param token
     * @return
     */
    @RequestMapping("findRebate")
    @ResponseBody
    public ResultJson findRebate(String token,Byte serise){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            List<Map<String,Object>>  list = walletService.getRebate(userId,serise);
            result = new ResultJson(true,"查询成功",list);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("findRecharge")
    @ResponseBody
    public ResultJson findRecharge(String token,byte serise,int start,int pageSize){
        ResultJson result;
        try {
            Integer userId = Permission.getUserId(token);
            Page page = walletService.findRechargePage(userId,serise,start,pageSize);
            result = new ResultJson(true,"查询成功",page);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }



}
