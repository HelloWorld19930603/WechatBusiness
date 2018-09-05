package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.exception.AccountException;
import com.yilin.app.exception.StatusException;
import com.yilin.app.service.*;
import com.yilin.app.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
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
    @Autowired
    ICartService cartService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(String token, int start, int pageSize, Byte status) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            List list = orderService.selectList(userId, start, pageSize, status);
            Page page = new Page(pageSize, start, list.size(), list);
            result = new ResultJson(true, "查询成功", page);

        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public ResultJson findOne(String orderId, String token) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            Map<String, Object> order = orderService.findOrder(orderId);
            List<Map<String, Object>> commList = orderService.selectDetails(orderId);
            order.put("commList", commList);
            result = new ResultJson(true, "查询成功", order);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }


    /**
     * 获取特定状态下订单数量
     *
     * @return
     */
    @RequestMapping("findCount")
    @ResponseBody
    public ResultJson findCount(String token) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            List<Map<String, Integer>> numList = orderService.getAllCount(userId);
            result = new ResultJson(true, "查询成功", numList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询失败");
        }
        return result;
    }

    /**
     * 创建订单
     *
     * @param orders
     * @return
     */
    @RequestMapping("createOrders")
    @ResponseBody
    public ResultJson createOrders(@RequestBody Map<String, Object> orders,String cartId) {
        ResultJson result;
        try {
            int userId = Permission.getUserId((String) orders.get("token"));
            String orderId = orderService.createOrder(userId, orders);
            result = new ResultJson(true, "创建成功", orderId);
            if(StringUtil.isNotEmpty(cartId)){
                cartService.deleteCart(cartId,userId);
            }
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
     * @param token
     * @param type
     * @param payPwd
     * @return
     */
    @RequestMapping("payOrder")
    @ResponseBody
    public ResultJson payOrder(String orderId, String token, String type, String payPwd) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            if (userService.checkPayPwd(userId, payPwd)) {
                orderService.payOrder(orderId, userId, type);
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
    public ResultJson removeOne(String orderId, String token) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            orderService.removeOrder(orderId, userId);
            result = new ResultJson(true, "删除订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "删除订单失败");
        }
        return result;
    }

    @RequestMapping("refund")
    @ResponseBody
    public ResultJson refund(String orderId, String token) {
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            orderService.refund(orderId, userId, (byte) 5);
            result = new ResultJson(true, "订单退款成功");
        }catch (StatusException se){
            result = new ResultJson(false, se.getMsg());
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "订单退款失败");
        }
        return result;
    }
}
