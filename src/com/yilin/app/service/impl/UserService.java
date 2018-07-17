package com.yilin.app.service.impl;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.UserMapper;
import com.yilin.app.service.IUserService;
import com.yilin.app.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/16.
 */
@Service
public class UserService implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void register(User user) throws Exception {
        String pwd = MD5Util.encrypt(user.getLoginPwd());
        user.setLoginPwd(pwd);
        userMapper.insertSelective(user);
    }

    @Override
    public User selectForLogin(String loginName, String loginPwd) throws Exception {
        String pwd = MD5Util.encrypt(loginName);
        return userMapper.selectOne(loginName,pwd);
    }
}
