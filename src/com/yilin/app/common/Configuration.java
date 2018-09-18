package com.yilin.app.common;

import org.apache.commons.collections.map.HashedMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by cc on 2018/7/28.
 */
public class Configuration {

    //private static LoggerUtil log =  new LoggerUtil(Configuration.class);

    public static String MESSAGE_KEY;
    public static String LOGISTICS_KEY;
    public static String MESSAGE_MODEL_1;
    public static String MESSAGE_MODEL_2;
    public static String MESSAGE_MODEL_3;
    public static String LOGIN_PWD_DEFAULT;
    public static String PAY_PWD_DEFAULT;

    public static Map<String,Integer> urls;

    static {
        getUrlConfig("/permission.properties");
        getKeyConfig("/appkey.properties");
    }

    private static void getUrlConfig(String properties){
        Properties prop;
        InputStream in = Configuration.class
                .getResourceAsStream(properties);
        try {
            prop = new Properties();
            prop.load(in);
            Set<Map.Entry<Object,Object>> set = prop.entrySet();
            Iterator iterator = set.iterator();
            urls = new HashedMap();
            while( iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                urls.put(entry.getKey().toString(),Integer.valueOf(entry.getValue().toString()));
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
           // log.e("permission.properties 加载失败");
        }
    }

    private static void getKeyConfig(String properties){
        Properties prop;
        InputStream in = Configuration.class
                .getResourceAsStream(properties);
        try {
            prop = new Properties();
            prop.load(in);
            MESSAGE_KEY = prop.getProperty("message_key");
            LOGISTICS_KEY = prop.getProperty("logistics_key");
            MESSAGE_MODEL_1 = prop.getProperty("message_model1");
            MESSAGE_MODEL_2 = prop.getProperty("message_model2");
            MESSAGE_MODEL_3 = prop.getProperty("message_model3");
            LOGIN_PWD_DEFAULT = prop.getProperty("login_pwd_default");
            PAY_PWD_DEFAULT = prop.getProperty("pay_pwd_default");
            System.out.println(MESSAGE_KEY);
            System.out.println(LOGISTICS_KEY);
        } catch (IOException e) {
            e.printStackTrace();
            //log.e("appkey.properties 加载失败");
        }
    }

    public static void main(String[] s){
        System.out.println();
    }
}
