package com.yilin.app.service.impl;

import com.yilin.app.domain.Commodity;
import com.yilin.app.domain.OrderComm;
import com.yilin.app.domain.Orders;
import com.yilin.app.domain.Payment;
import com.yilin.app.exception.AccountException;
import com.yilin.app.exception.StatusException;
import com.yilin.app.mapper.*;
import com.yilin.app.service.IOrderService;
import com.yilin.app.utils.OrderNumberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    OrdersMapper ordersMapper;
    @Resource
    PaymentMapper paymentMapper;
    @Autowired
    OrderCommMapper orderCommMapper;
    @Autowired
    WalletMapper walletMapper;
    @Autowired
    CommodityMapper commodityMapper;


    @Override
    public List selectList(Integer userId, int start, int pageSize, Byte status) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("status", status);
        List<Map<String, Object>> list = ordersMapper.selectList(map);
        for (Map<String, Object> orderMap : list) {
            map.clear();
            map.put("orderId", orderMap.get("id"));
            map.put("userId", orderMap.get("userId"));
            orderMap.put("commList", orderCommMapper.selectList(map));
        }
        return list;
    }

    @Override
    public List selectList2(Integer userId, Byte status, Byte serise, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", (start - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("status", status);
        map.put("serise", serise);
        List<Map<String, Object>> list = ordersMapper.selectList2(map);

        return list;
    }


    @Override
    public List<Map<String, Object>> selectDetails(String orderId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);
        return orderCommMapper.selectList(map);
    }

    @Override
    public void updateStatus(String id, Integer userId, int status,Integer oldStatus) throws AccountException {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("status", status);
            map.put("oldStatus", oldStatus);
            map.put("orderId", id);
            ordersMapper.updateStatus(map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccountException("修改订单状态异常！如有疑问请联系管理员！");
        }
    }

    @Override
    public Map<String, Object> findOrder(String orderId) throws Exception {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public String createOrder(int userId, Map<String, Object> ordersMap) throws Exception {
        List<Map<String, Object>> commIds = (List<Map<String, Object>>) ordersMap.get("commIds");
        int serise = checkCommId(commIds);
        Orders order = new Orders();
        order.setSerise((byte)serise);
        order.setTime(new Date());
        order.setStatus((byte) 1);
        order.setUserId(userId);
        order.setAddrId((int) ordersMap.get("addrId"));
        order.setDescription((String) ordersMap.get("description"));
        String orderId = OrderNumberBuilder.getOrderIdByUUId();
        for (Map<String, Object> map : commIds) {
            order.setId(orderId);
            OrderComm orderComm = new OrderComm();
            orderComm.setOrderId(orderId);
            orderComm.setCommId((int) map.get("commId"));
            orderComm.setNum((int) map.get("num"));
            map.put("userId",userId);
            Commodity commodity = commodityMapper.selectOne(map);
            orderComm.setPrice(commodity.getaPrice());
            orderComm.setSerise(commodity.getSerise());
            orderCommMapper.insert(orderComm);
        }
        ordersMapper.insert(order);
        return orderId;
    }

    public int checkCommId(List<Map<String, Object>> commIds) throws Exception {
        Set<Object> set = new HashSet<>();
        for(Map<String, Object> map : commIds){
            set.add(map.get("serise"));
        }
        if(set.size()!=1){
            throw new StatusException("请提交相同系列的商品");
        }
        return (int)set.toArray()[0];
    }

    @Override
    public int getCount(Integer userId, Byte status, Byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("status", status);
        map.put("serise", serise);
        return ordersMapper.count(map);
    }

    @Override
    public List<Map<String, Integer>> getAllCount(Integer userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        return ordersMapper.countAll(map);
    }

    @Override
    public void payOrder(String orderId, int userId, String type) throws AccountException {
        byte oldStatus = ordersMapper.selectStatus(orderId);
        if(oldStatus != 1){
            throw new AccountException("订单状态异常");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("orderId", orderId);
        try {
            if(walletMapper.getMoney2(map)!=null) {
                Payment payment = new Payment();
                payment.setTime(new Date());
                payment.setOrderId(orderId);
                payment.setType(type);
                payment.setUserId(userId);
                walletMapper.takeMoney(map);
                paymentMapper.insert(payment);
                updateStatus(orderId,userId,2,1);
            }else {
                throw new AccountException("您的余额不足，请充值！");
            }
        } catch (AccountException ae){
            throw ae;
        }catch (Exception e) {
            e.printStackTrace();
            throw new AccountException("支付异常！如有疑问请联系管理员！");
        }
    }

    @Override
    public void removeOrder(String id, int userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("id", id);
        ordersMapper.deleteById(map);
        orderCommMapper.deleteAll(id);
    }

    @Override
    public void refund(String orderId, int userId, byte status) throws Exception {
        byte oldStatus = ordersMapper.selectStatus(orderId);
        if(oldStatus != 2){
            throw new StatusException("订单状态异常");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("status", status);
        map.put("orderId", orderId);
        Float money = orderCommMapper.countMoney(map);
        if(money == null){
            throw new StatusException("订单金额异常");
        }
        ordersMapper.updateStatus(map);
        map.put("money",money);
        walletMapper.refundMoney(map);
    }
}
