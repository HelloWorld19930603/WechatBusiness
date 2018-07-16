package com.yilin.app.service.impl;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.UserMapper;
import com.yilin.app.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/16.
 */
@Service
public class UserInfoService implements IUserInfoService{

    @Resource
    UserMapper userMapper;

    @Override
    public void register(User user) throws Exception {
        userMapper.insertSelective(user);
    }
}
