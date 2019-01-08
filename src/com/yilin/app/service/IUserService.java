package com.yilin.app.service;

import com.yilin.app.domain.User;

import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> selectBySerise(Byte serise, String phone, String name, Byte status, int start, int pageSize);

    int selectNumBySerise(Byte serise, String phone, String name, Byte status)throws Exception;

    User selectByLoginName(String loginName)throws Exception;

    List<Map<String,Object>> selectTeam(int serise, int userId)throws Exception;

    String switchRole(int serise, int roleId);

    List<Map<String,Object>> selectByRole(Byte serise, int roleId, Byte status);

    User selectById(Integer userId) throws Exception;
}
