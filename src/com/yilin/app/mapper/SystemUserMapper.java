package com.yilin.app.mapper;

import com.yilin.app.domain.SystemUser;
import com.yilin.app.mapper.base.IBaseMapper;

public interface SystemUserMapper extends IBaseMapper<SystemUser>{

    SystemUser selectForLogin(String loginName, String loginPwd);
}