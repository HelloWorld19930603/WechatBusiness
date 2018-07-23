package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Orders;
import com.yilin.app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/9.
 */
@Controller
@RequestMapping("order")
public class OrderContorller {

    @Autowired
    IOrderService orderService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(Integer userId, int index, int pageSize) {
        ResultJson result;
        try {
            if (userId != null) {
                Page page = orderService.selectPage(userId, index, pageSize);
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
    public ResultJson findPage(int id) {
        ResultJson result;
        try {
            Orders order = orderService.findOrder(id);
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
            orderService.createOrder(order);
            result = new ResultJson(true, "创建成功");
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
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping("payOrder")
    @ResponseBody
    public ResultJson payOrder(int orderId, int userId, int type) {
        ResultJson result;
        try {

            result = new ResultJson(true, "支付成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "支付失败");
        }
        return result;
    }


    @RequestMapping("removeOne")
    @ResponseBody
    public ResultJson removeOne(int orderId, int userId) {
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
