package com.yilin.system.service;

import com.yilin.app.domain.Recharge;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
public interface IRechargeAuditService {

    void updateStatus(byte status) throws Exception;

    int getCount(Byte status, Byte serise, String phone, String userId)throws Exception;

    List selectList(Byte status, Byte serise, String phone, String userId, int start, int pageSize)throws Exception;

    Recharge selectOne(int id)throws Exception;

    void editOne(Recharge recharge)throws Exception;

    void removeOne(int id)throws Exception;

    void audit(int id, byte status)throws Exception;
}
