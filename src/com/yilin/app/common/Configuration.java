package com.yilin.app.common;

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


    private static Properties prop;

    static {
        InputStream in = Configuration.class
                .getResourceAsStream("/database2.properties");
        try {
            prop = new Properties();
            prop.load(in);
            Set<Map.Entry<Object,Object>> set = prop.entrySet();
            Iterator iterator = set.iterator();
           while( iterator.hasNext()){
               Map.Entry entry = (Map.Entry) iterator.next();
               System.out.println(entry.getKey());
               System.out.println(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] s){
        System.out.println();
    }
}
