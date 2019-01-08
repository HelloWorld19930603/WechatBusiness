package com.yilin.system.service;

import com.yilin.app.domain.Agent;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/28.
 */
public interface IAgentAuditService {

    void updateStatus(byte status) throws Exception;

    int getCount(Byte status, Byte serise, String phone, String name)throws Exception;

    List selectList(Byte status, Byte serise, String phone, String name, int start, int pageSize)throws Exception;

    Map selectOne(int id)throws Exception;

    void removeOne(int id)throws Exception;

    void audit(int id, byte status, int userId, int auditor, String remark, int serise)throws Exception;

    void addOne(Agent agent)throws Exception;
}
