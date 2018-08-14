package com.yilin.app.common;

import com.yilin.app.domain.User;
import com.yilin.app.utils.MD5Util;
import com.yilin.app.utils.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2018/7/16.
 */
public class Permission {

    public static Map<String, UserInfo> userLoginMap = new HashMap<>();

    public static boolean checkToken(String token) {
        if (userLoginMap.get(token) != null) {
            return true;
        }
        return false;
    }

    public static String createToken(User user) throws Exception {
        if (user == null) {
            throw new Exception("user不能为null");
        }
        String token = MD5Util.encrypt(user.getLoginName() + user.getLoginPwd());

        userLoginMap.put(token, createUserInfo(user));
        return token;
    }

    public static UserInfo createUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setHeadImg(user.getHeadImg());
        userInfo.setName(user.getName());
        userInfo.setSex(user.getSex());
        userInfo.setCurr_time(new Date());
        userInfo.setLast_time(user.getLoginTime());
        return userInfo;
    }

    public static boolean checkLevel(int level, int serise) {


        return false;
    }

    public static void cancel(String token) throws Exception {
        if (StringUtil.isEmpty(token)) {
            throw new Exception("token不能为null");
        }
        userLoginMap.remove(token);
    }

    public static UserInfo getToken(String token) {
        return userLoginMap.get(token);
    }

    public static Integer getUserId(String token) {
        if(token == null){
            return null;
        }
        UserInfo userInfo = getToken(token);
        return userInfo == null ? null : userInfo.getId();
    }
}
