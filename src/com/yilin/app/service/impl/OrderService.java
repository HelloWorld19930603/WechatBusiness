package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Orders;
import com.yilin.app.domain.Payment;
import com.yilin.app.mapper.OrdersMapper;
import com.yilin.app.mapper.PaymentMapper;
import com.yilin.app.service.IOrderService;
import com.yilin.app.exception.AccountException;
import com.yilin.app.utils.OrderNumberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    OrdersMapper ordersMapper;
    @Resource
    PaymentMapper paymentMapper;

    @Override
    public Page selectPage(Integer userId, int start, int pageSize, Byte status) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("status", status);
        List<Map<String, Object>> list = ordersMapper.selectList(map);
        Page page = new Page(pageSize, start, list.size(), list);
        return page;
    }

    @Override
    public void updateStatus(String id, int userId, int status) throws AccountException {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            map.put("status", status);
            map.put("id", id);
            ordersMapper.updateStatus(map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccountException("修改订单状态异常！如有疑问请联系管理员！");
        }
    }

    @Override
    public Orders findOrder(String orderId) throws Exception {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public void createOrder(int userId,Map<String,Object> ordersMap) throws Exception {
        Orders order = new Orders();
        order.setTime(new Date());
        order.setStatus((byte) 1);
        order.setUserId(userId);
        order.setAddrId((int)ordersMap.get("addrId"));
        order.setDescription((String)ordersMap.get("description"));
        List<Map<String,Object>> commIds =  (List<Map<String,Object>>) ordersMap.get("commIds");
        for(Map<String,Object> map : commIds){
            String orderId = OrderNumberBuilder.getOrderIdByUUId();
            order.setId(orderId);
            order.setCommId((int)map.get("commId"));
            order.setNum((int)map.get("num"));
            ordersMapper.insert(order);
        }
    }

    @Override
    public int getCount(Integer userId, Integer status) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("status", status);
        return ordersMapper.count(map);
    }

    @Override
    public void payOrder(String orderId,int userId,float money,String type) throws AccountException {
        try {
            Payment payment = new Payment();
            payment.setTime(new Date());
            payment.setOrderId(orderId);
            payment.setType(type);
            payment.setMoney(money);
            payment.setUserId(userId);
            paymentMapper.insert(payment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccountException("扣款成功，生成支付凭证异常！如有疑问请联系管理员！");
        }
    }

    @Override
    public void removeOrder(String id, int userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("id", id);
        ordersMapper.deleteById(map);
    }
}
