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
}
