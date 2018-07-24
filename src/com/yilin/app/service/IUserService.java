package com.yilin.app.service;

import com.yilin.app.domain.User;

/**
 * Created by cc on 2018/7/16.
 */
public interface IUserService {

    void register(User user) throws Exception;

    User selectForLogin(String loginName, String loginPwd) throws Exception;

    void updateUser(User user) throws Exception;

    User findUser(int userId) throws Exception;


    void updateLoginPwd(int userId, String newPwd) throws Exception;

    void updatePayPwd(int userId, String newPwd) throws Exception;

    void updateHead(int userId, String headImg) throws Exception;

    boolean checkLoginPwd(int userId, String loginPwd) throws Exception;

    boolean checkPayPwd(int userId, String payPwd) throws Exception;
}
