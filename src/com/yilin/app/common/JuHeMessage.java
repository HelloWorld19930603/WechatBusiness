package com.yilin.app.common;

import com.yilin.app.exception.RequestException;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 短信API服务调用示例代码 － 聚合数据
 * 在线接口文档：http://www.juhe.cn/docs/54
 **/

public class JuHeMessage {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


    //1.屏蔽词检查测
    public static void getRequest1() throws Exception {
        String url = "http://v.juhe.cn/sms/black";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("word", "");//需要检测的短信内容，需要UTF8 URLENCODE
        params.put("key", Configuration.MESSAGE_KEY);//应用APPKEY(应用详细页查询)

        sendRequest(url, params);
    }

    public static String sendRequest(String url, Map params) throws Exception {
        String result;
        result = net(url, params, "GET");
        JSONObject object = JSONObject.fromObject(result);
        if (object.getInt("error_code") == 0) {
            System.out.println(object.get("result"));
            return (String) object.get("result");
        } else {
            System.out.println(object.get("error_code") + ":" + object.get("reason"));
            throw new RequestException(object.get("error_code") + ":" + object.get("reason"));
        }

    }

    //2.发送短信
    public static void getRequest2(String phone, String code, String tpl_id) throws Exception {
        String url = "http://v.juhe.cn/sms/send";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("mobile", phone);//接收短信的手机号码
        params.put("tpl_id", tpl_id);//短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_value", code);//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
        params.put("key", Configuration.MESSAGE_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "");//返回数据的格式,xml或json，默认json

        sendRequest(url, params);
    }


    public static void main(String[] args) throws Exception {
        getRequest2("16657102793", "#code#=16657102793&#pwd#=123456", Configuration.MESSAGE_MODEL);
    }

    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String createCode() {
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }
}
