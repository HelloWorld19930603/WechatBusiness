package com.yilin.app.mapper;

import com.yilin.app.domain.Wallet;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.Map;

public interface WalletMapper extends IBaseMapper<Wallet> {

    void addMoney(Map<String, Object> map) throws Exception;

    float getMoney(Map<String, Object> map);
}