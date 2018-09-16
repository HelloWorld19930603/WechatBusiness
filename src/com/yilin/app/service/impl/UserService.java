package com.yilin.app.service.impl;

import com.yilin.app.domain.User;
import com.yilin.app.mapper.UserMapper;
import com.yilin.app.service.IUserService;
import com.yilin.app.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/16.
 */
@Service
public class UserService implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void register(User user) throws Exception {
        String loginPwd = MD5Util.encrypt(user.getLoginPwd());
        String payPwd =  MD5Util.encrypt(user.getPayPwd());
        user.setLoginPwd(loginPwd);
        user.setPayPwd(payPwd);
        user.setLoginTime(new Date());
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
    public void updateLoginPwd(int userId, String newPwd) throws Exception{
        User user = new User();
        user.setId(userId);
        user.setLoginPwd(MD5Util.encrypt(newPwd));
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updatePayPwd(int userId, String newPwd) throws Exception{
        User user = new User();
        user.setId(userId);
        user.setPayPwd(newPwd);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateHead(int userId, String headImg) throws Exception {
        User user = new User();
        user.setId(userId);
        user.setHeadImg(headImg);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public boolean checkLoginPwd(int userId, String loginPwd) throws Exception {

        User user = userMapper.selectByPrimaryKey(userId);
        if(MD5Util.encrypt(loginPwd).equals(user.getLoginPwd())){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPayPwd(int userId, String payPwd) throws Exception {
        User user = userMapper.selectByPrimaryKey(userId);
        if(MD5Util.encrypt(payPwd).equals(user.getPayPwd())){
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> selectBySerise(Byte serise,String phone,String name, Byte status,int start, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("serise",serise);
        map.put("phone",phone);
        map.put("name",name);
        map.put("status",status);
        map.put("start",(start-1)*pageSize);
        map.put("pageSize",pageSize);
        return userMapper.selectBySerise(map);
    }

    @Override
    public int selectNumBySerise(Byte serise,String phone,String name, Byte status) {
        Map<String,Object> map = new HashMap<>();
        map.put("serise",serise);
        map.put("phone",phone);
        map.put("name",name);
        return userMapper.selectNumBySerise(map);
    }

    @Override
    public User selectByLoginName(String loginName) throws Exception {
        return userMapper.selectForName(loginName);
    }

    @Override
    public List<Map<String, Object>> selectTeam(int serise, int userId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("serise",serise);
        map.put("userId",userId);
        return userMapper.selectTeam(map);
    }


    @Override
    public String switchRole(int serise,int roleId){
        switch (serise){
            case 1:switch (roleId){
                case 1: return "股东";
                case 2: return "联创";
                case 3: return "执行董事";
                case 4: return "官方";
                case 5: return "总代理";
                case 6: return "一级代理";
                case 7: return "二级代理";
                case 8: return "特约";
            };
            case 2 : switch (roleId){
                case 1: return "股东";
                case 2: return "合伙人";
                case 3: return "经理";
                case 4: return "执行董事";
                case 5: return "官方";
                case 6: return "总代";
                case 7: return "体验";
            };
            case 3:switch (roleId){
                case 1: return "股东";
                case 2: return "合伙人";
                case 3: return "执行董事";
                case 4: return "官方";
                case 5: return "总代理";
                case 6: return "一级代理";
                case 7: return "体验";
            };
        }
        return "";
    }

    @Override
    public List<Map<String, Object>> selectByRole(Byte serise, int roleId, Byte status) {
        Map<String,Object> map = new HashMap<>();
        map.put("serise",serise);
        map.put("roleId",roleId);
        map.put("status",status);
        return userMapper.selectByRole(map);
    }

    @Override
    public User selectById(Integer userId) throws Exception {
        return userMapper.selectByPrimaryKey(userId);
    }
}
