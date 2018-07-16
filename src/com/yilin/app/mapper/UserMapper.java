package com.yilin.app.mapper;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper  extends IBaseMapper<User> {

    User selectOne(@Param("loginName")String loginName,@Param("loginPwd") String loginPwd);
}