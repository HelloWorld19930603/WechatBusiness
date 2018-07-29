package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Recharge;
import com.yilin.app.exception.AccountException;

/**
 * Created by cc on 2018/7/20.
 */
public interface IWalletService {


        void addRecharge(Recharge recharge) throws Exception;

    Page findRechargePage(int userId, byte serise, int start, int pageSize) throws Exception;

    void addMoney(byte serise, int userId, float money) throws Exception;

        void takeMoney(byte serise, int userId, float money) throws AccountException;

        float getMoney(int userId, byte serise) throws Exception;

        Page getRebate(int userId,int start,int pageSize) throws Exception;
}
