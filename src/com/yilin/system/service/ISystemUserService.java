package com.yilin.system.service;

import com.yilin.app.domain.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cc on 2018/8/26.
 */
public interface ISystemUserService {

    List<SystemUser> selectPage(String name, String phone, String loginName, int start, int pageSize) throws Exception;

    void editOne(SystemUser user) throws Exception;

    void deleteOne(int id) throws Exception;

    void addOne(SystemUser user) throws Exception;

    int selectCount(String name, String phone, String loginName) throws Exception;

    SystemUser selectForLogin(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd) throws Exception;
}
