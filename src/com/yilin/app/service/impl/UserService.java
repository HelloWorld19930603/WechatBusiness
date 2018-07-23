package com.yilin.app.service.impl;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.UserMapper;
import com.yilin.app.service.IUserService;
import com.yilin.app.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        String pwd = MD5Util.encrypt(loginPwd);
        User user =  userMapper.selectForLogin(loginName,pwd);
        if(user != null){
            user.setLoginTime(new Date());
            userMapper.updateByPrimaryKey(user);
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findUser(int userId) throws Exception {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updatePwd(int userId, String oldPwd, String newPwd) {

    }

    @Override
    public void updateHead(int userId, String headImg) throws Exception {

    }

    @Override
    public boolean checkLoginPwd(int userId, String loginPwd) throws Exception {
        return false;
    }

    @Override
    public boolean checkPayPwd(int userId, String payPwd) throws Exception {
        return false;
    }
}
