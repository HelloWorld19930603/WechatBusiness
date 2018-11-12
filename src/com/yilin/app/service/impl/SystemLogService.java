package com.yilin.app.service.impl;

import com.yilin.app.domain.SystemLog;
import com.yilin.app.mapper.SystemLogMapper;
import com.yilin.app.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2018/10/16.
 */
@Service
public class SystemLogService implements ISystemLogService {

    @Autowired
    SystemLogMapper systemLogMapper;

    @Override
    public void log(SystemLog log) {
        try {
            systemLogMapper.insertSelective(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
