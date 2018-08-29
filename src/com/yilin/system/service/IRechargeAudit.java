package com.yilin.system.service;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
public interface IRechargeAudit {

    void updateStatus(byte status) throws Exception;

    int getCount(Byte status,Byte serise,String phone,String name)throws Exception;

    List selectList(Byte status, Byte serise, String phone, String name)throws Exception;

    Map selectOne(int id)throws Exception;

    void removeOne(int id)throws Exception;

    void auditPass(int id)throws Exception;
}
