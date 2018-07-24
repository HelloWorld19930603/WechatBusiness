package com.yilin.app.service.impl;

import com.yilin.app.common.Page;
import com.yilin.app.domain.Recharge;
import com.yilin.app.service.IWalletService;

/**
 * Created by cc on 2018/7/23.
 */
public class WalletService implements IWalletService {




    @Override
    public void addRecharge(Recharge recharge) throws Exception {

    }

    @Override
    public void addMoney() throws Exception {

    }

    @Override
    public float getMoney(int userId, byte serise) throws Exception {
        return 0;
    }

    @Override
    public Page getRebate(int userId, int start, int pageSize) throws Exception {
        return null;
    }
}
