package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Rebate;
import com.yilin.app.domain.Recharge;
import com.yilin.app.mapper.RebateMapper;
import com.yilin.app.mapper.RechargeMapper;
import com.yilin.app.mapper.WalletMapper;
import com.yilin.app.service.IWalletService;
import com.yilin.app.utils.AccountException;
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


    @Override
    public void addRecharge(Recharge recharge) throws Exception {
        rechargeMapper.insert(recharge);
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
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("serise", serise);
            map.put("userId", userId);
            map.put("money", money);
            walletMapper.takeMoney(map);
        } catch (Exception e) {
            throw new AccountException("钱包扣款异常!");
        }
    }

    @Override
    public float getMoney(int userId, byte serise) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("serise", serise);
        map.put("userId", userId);

        return walletMapper.getMoney(map);
    }

    @Override
    public Page getRebate(int userId, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("start", (start - 1) * pageSize);
        map.put("userId", userId);
        map.put("pageSize", pageSize);
        List<Rebate> list = rebateMapper.selectPage(map);
        return new Page(pageSize,start,list.size(),list);
    }
}
