package com.yilin.app.common;

import com.yilin.app.domain.User;
import com.yilin.app.utils.MD5Util;
import com.yilin.app.utils.StringUtil;

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

    public static String createToken(User user) throws Exception {
        if(user == null){
            throw new Exception("user不能为null");
        }
        String token = MD5Util.encrypt(user.getLoginName()+user.getLoginPwd());
        user.setLoginPwd("");
        user.setPayPwd("");
        userLoginMap.put(token,user);
        return token;
    }

    public static void cancel(String token) throws Exception{
        if(StringUtil.isEmpty(token)){
            throw new Exception("token不能为null");
        }
        userLoginMap.remove(token);
    }

    public static User getToken(String token){
        return userLoginMap.get(token);
    }

}
