package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Commodity;
import com.yilin.app.domain.Orders;
import com.yilin.app.exception.AccountException;
import com.yilin.app.service.ICommodityService;
import com.yilin.app.service.IOrderService;
import com.yilin.app.service.IUserService;
import com.yilin.app.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2018/7/9.
 */
@Controller
@RequestMapping("order")
public class OrderAction {

    @Autowired
    IOrderService orderService;
    @Resource
    IWalletService walletService;
    @Resource
    IUserService userService;
    @Resource
    ICommodityService commodityService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(Integer userId, int start, int pageSize, Byte status) {
        ResultJson result;
        try {
            if (userId != null) {
                Page page = orderService.selectPage(userId, start, pageSize, status);
                result = new ResultJson(true, "查询成功", page);
            } else {
                result = new ResultJson(false, "userId不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public ResultJson findOne(String orderId) {
        ResultJson result;
        try {
            Orders order = orderService.findOrder(orderId);
            Commodity commodity = commodityService.selectById(order.getCommId(), order.getUserId());
            Map<String, Object> map = new HashMap<>();
            map.put("order", order);
            map.put("commodity", commodity);
            result = new ResultJson(true, "查询成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }


    /**
     * 获取特定状态下订单数量
     *
     * @param userId
     * @param status
     * @return
     */
    @RequestMapping("findCount")
    @ResponseBody
    public ResultJson findCount(int userId, Integer status) {
        ResultJson result;
        try {

            int num = orderService.getCount(userId, status);
            result = new ResultJson(true, "查询成功", num);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @RequestMapping("createOne")
    @ResponseBody
    public ResultJson createOne(Orders order) {
        ResultJson result;
        try {
            order.setStatus((byte) 1);
            String orderId = orderService.createOrder(order);
            result = new ResultJson(true, "创建成功", orderId);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "创建失败");
        }
        return result;
    }

    /**
     * 支付订单
     *
     * @param orderId
     * @param serise
     * @param userId
     * @param type
     * @param money
     * @param payPwd
     * @return
     */
    @RequestMapping("payOrder")
    @ResponseBody
    public ResultJson payOrder(String orderId, byte serise, int userId, String type, float money, String payPwd) {
        ResultJson result;
        try {
            if (userService.checkPayPwd(userId, payPwd)) {
                walletService.takeMoney(serise, userId, money);
                orderService.payOrder(orderId, userId, money, type);
                orderService.updateStatus(orderId, userId, 2);
                result = new ResultJson(true, "支付成功", orderId);
            } else {
                result = new ResultJson(false, "支付密码错误", orderId);
            }
        } catch (AccountException e) {
            result = new ResultJson(false, e.getMsg(), orderId);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "支付密码校验异常", orderId);
        }
        return result;
    }


    @RequestMapping("removeOne")
    @ResponseBody
    public ResultJson removeOne(String orderId, int userId) {
        ResultJson result;
        try {
            orderService.removeOrder(orderId, userId);
            result = new ResultJson(true, "取消订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "取消订单失败");
        }
        return result;
    }
}
