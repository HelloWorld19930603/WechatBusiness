package com.yilin.app.mapper;

import com.yilin.app.domain.Wallet;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.List;
import java.util.Map;

public interface WalletMapper extends IBaseMapper<Wallet> {

    void addMoney(Map<String, Object> map) throws Exception;

    Float getMoney(Map<String, Object> map);

    Float getMoney2(Map<String, Object> map);

    void takeMoney(Map<String, Object> map);

    List<Map<String,Object>> selectRecords(Map<String, Object> map) throws Exception;
}