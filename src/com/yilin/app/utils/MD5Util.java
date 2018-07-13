package com.yilin.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cc on 2018/7/12.
 */
public class MD5Util {

    public static String encrypt(String pwd) throws NoSuchAlgorithmException {
        pwd = pwd.trim();
        StringBuilder Digest = new StringBuilder("");
        MessageDigest currentAlgorithm = MessageDigest.getInstance("md5");
        currentAlgorithm.reset();
        byte[] hash = currentAlgorithm.digest(pwd.getBytes());
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i];
            if (v < 0)
                v = 256 + v;
            if (v < 16)
                Digest.append("0") ;
            Digest.append(Integer.toString(v, 16));
        }
        return Digest.toString();
    }
}
