package com.yilin.app.filter;


import com.alibaba.fastjson.JSONObject;
import com.yilin.app.common.Configuration;
import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cc on 2018/7/12.
 */
public class LoginFilter implements Filter {

    private FilterConfig config;

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.println("doFilter");
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        response.setCharacterEncoding("utf-8");
        ResultJson result;
        String url = request.getRequestURI();
        Integer level = Configuration.urls.get(url);
        String token = (String) request.getSession().getAttribute("token");
        if (token == null) {
            token = request.getParameter("token");
        }
        if(token != null && Permission.getUserInfo(token) == null){
            result = new ResultJson(false, "token无效",1);
            String jsonString = JSONObject.toJSONString(result);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(jsonString);
            return;
        }
        if (level != null) {

            if (token == null) {
                result = new ResultJson(false, "token不能为空！",1);
                String jsonString = JSONObject.toJSONString(result);
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().print(jsonString);
                return;
            } else {

                if (!Permission.checkToken(token)) {
                    result = new ResultJson(false, "token校验失败！",1);
                    String jsonString = JSONObject.toJSONString(result);
                    response.setContentType("application/json; charset=utf-8");
                    response.getWriter().print(jsonString);
                    return;
                }
/*
                 Byte serise = (Byte) request.getSession().getAttribute("serise");
                if (serise == null) {
                    serise = Byte.valueOf(request.getParameter("token"));
                    if (serise == null) {

                    }
                }
                if (!Permission.checkLevel(level, serise)) {
                    result = new ResultJson(false, "该用户无此系列访问权限！");
                    String jsonString = JSONObject.toJSONString(result);
                    response.setContentType("application/json; charset=utf-8");
                    response.getWriter().print(jsonString);
                    return;
                }*/
                arg2.doFilter(arg0, arg1);
            }
        } else {
            arg2.doFilter(arg0, arg1);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("init");
    }

}
