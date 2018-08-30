package com.yilin.app.mapper;

import com.yilin.app.domain.SystemUser;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface SystemUserMapper extends IBaseMapper<SystemUser>{

    SystemUser selectForLogin(@Param(value = "loginName") String loginName,@Param(value = "loginPwd") String loginPwd);
}