package com.yilin.system.service.impl;

import com.yilin.app.domain.SystemUser;
import com.yilin.app.mapper.SystemUserMapper;
import com.yilin.app.utils.MD5Util;
import com.yilin.system.service.ISystemUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/26.
 */
@Service
public class SystemUserService implements ISystemUserService {

    @Autowired
    SystemUserMapper systemUserMapper;

    @Override
    public List<com.yilin.app.domain.SystemUser> selectPage(String name, String phone, String loginName, int start, int pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(start-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("phone",phone);
        map.put("loginName",loginName);
        return systemUserMapper.selectPage(map);
    }

    @Override
    public void editOne(SystemUser user) throws Exception {
        systemUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteOne(int id) throws Exception {
        systemUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addOne(SystemUser user) throws Exception {
        user.setLoginPwd(MD5Util.encrypt(user.getLoginPwd()));
        systemUserMapper.insert(user);
    }

    @Override
    public int selectCount(String name, String phone, String loginName) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("phone",phone);
        map.put("loginName",loginName);
        return systemUserMapper.count(new HashedMap());
    }

    @Override
    public SystemUser selectForLogin(String loginName, String loginPwd) throws Exception {
        return systemUserMapper.selectForLogin(loginName, MD5Util.encrypt(loginPwd));
    }

    @Override
    public void editPwd(int id,String oldPwd, String newPwd) throws Exception {
        SystemUser user = systemUserMapper.selectByPrimaryKey(id);
        if(user.getLoginPwd().equals(MD5Util.encrypt(oldPwd))){
            user.setLoginPwd(MD5Util.encrypt(newPwd));
            systemUserMapper.insertSelective(user);
        }
    }
}
