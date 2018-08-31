package com.yilin.app.mapper;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper  extends IBaseMapper<User> {

    User selectForLogin(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd);

    User selectForName(@Param("loginName") String loginName);

    List<Map<String, Object>> selectBySerise(Map<String, Object> map);

    int selectNumBySerise(Map<String, Object> map);
}