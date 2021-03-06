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

    void updateStatus(@Param("id") int id, @Param("status") byte status) throws Exception;

    List<Map<String,Object>> selectTeam(Map<String, Object> map);

    List<Map<String,Object>> selectByRole(Map<String, Object> map);
}