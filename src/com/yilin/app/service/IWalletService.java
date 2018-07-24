package com.yilin.app.service;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Recharge;

/**
 * Created by cc on 2018/7/20.
 */
public interface IWalletService {


        void addRecharge(Recharge recharge) throws Exception;

        void addMoney(byte serise,int userId,float money) throws Exception;

        float getMoney(int userId,byte serise) throws Exception;

        Page getRebate(int userId,int start,int pageSize) throws Exception;
}
