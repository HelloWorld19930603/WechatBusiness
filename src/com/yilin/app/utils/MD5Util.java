package com.yilin.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cc on 2018/7/12.
 */
public class MD5Util {

    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static MessageDigest mdInst;

    public static String encrypt(String s) throws NoSuchAlgorithmException {

        byte[] btInput = s.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        if (mdInst == null) {
            mdInst = MessageDigest.getInstance("MD5");
        }
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        byte byte0;
        for (int i = 0; i < j; i++) {
            byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(encrypt("aaa"));
    }

}
