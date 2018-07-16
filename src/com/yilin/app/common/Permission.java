package com.yilin.app.common;

import com.yilin.app.domain.User;
import com.yilin.app.utils.MD5Util;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2018/7/16.
 */
public class Permission {

    public static Map<String,User> userLoginMap = new HashMap<>();

    public static boolean checkToken(String token){
        if(userLoginMap.get(token) != null){
            return true;
        }
        return false;
    }

    public static String keepUser(User user) throws Exception {
        if(user == null){
            throw new Exception("user不能为null");
        }
        String token = MD5Util.encrypt(user.getLoginName()+user.getLoginPwd()+System.currentTimeMillis());
        userLoginMap.put(token,user);
        return token;
    }

}
