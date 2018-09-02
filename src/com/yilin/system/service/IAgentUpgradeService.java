package com.yilin.system.service;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/30.
 */
public interface IAgentUpgradeService {

    void updateStatus(byte status) throws Exception;

    int getCount(Byte status,Byte serise,String phone,String name)throws Exception;

    List selectList(Byte status, Byte serise,String phone, String name,int start,int pageSize)throws Exception;

    Map selectOne(int id)throws Exception;

    void removeOne(int id)throws Exception;

    void audit(int id,byte status)throws Exception;
}
