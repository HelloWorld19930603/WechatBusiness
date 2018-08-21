package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Recharge;
import com.yilin.app.exception.AccountException;
import com.yilin.app.mapper.PaymentMapper;
import com.yilin.app.mapper.RebateMapper;
import com.yilin.app.mapper.RechargeMapper;
import com.yilin.app.mapper.WalletMapper;
import com.yilin.app.service.IWalletService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/23.
 */
@Service
public class WalletService implements IWalletService {

    @Resource
    RechargeMapper rechargeMapper;

    @Resource
    WalletMapper walletMapper;

    @Resource
    RebateMapper rebateMapper;

    @Resource
    PaymentMapper paymentMapper;


    @Override
    public void addRecharge(Recharge recharge) throws Exception {
        rechargeMapper.insert(recharge);
    }

    @Override
    public Page findRechargePage(int userId, byte serise, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("serise", serise);
        map.put("userId", userId);
        map.put("start", (start-1)*pageSize);
        map.put("pageSize", pageSize);
        List<Recharge> list = rechargeMapper.selectPage(map);
        Page page = new Page(pageSize,start,list.size(),list);
        return page;
    }

    @Override
    public void addMoney(byte serise, int userId, float money) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("serise", serise);
        map.put("userId", userId);
        map.put("money", money);
        walletMapper.addMoney(map);
    }

    @Override
    public void takeMoney(byte serise, int userId, float money) throws AccountException {

        Map<String, Object> map = new HashMap<>();
        map.put("serise", serise);
        map.put("userId", userId);
        Float wallet = walletMapper.getMoney(map);
        if (wallet == null || money > wallet) {
            throw new AccountException("您的余额不足，请充值！");
        }
        map.put("money", money);
        walletMapper.takeMoney(map);

    }

    @Override
    public float getMoney(int userId, byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("serise", serise);
        map.put("userId", userId);
        Float money = walletMapper.getMoney(map);

        return money == null ? 0 : money;
    }

    @Override
    public List<Map<String, Object>> getRebate(int userId,Byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("serise", serise);
        List<Map<String,Object>> list = rebateMapper.selectList(map);
        return list;
    }
}
