package com.yilin.app.filter;


import org.apache.commons.collections.map.HashedMap;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by cc on 2018/7/12.
 */
public class SystemFilter implements Filter {


    public Map<String,String> urlMap;

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destroy2");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String url = request.getRequestURI();
        System.out.println("doFilter2 : " +url);
        if(urlMap.containsKey(url)){
            arg2.doFilter(arg0, arg1);
            return;
        }
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            arg2.doFilter(arg0, arg1);
        }else {
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        urlMap = new HashedMap();
        urlMap.put("/login.do","");
        urlMap.put("/toLogin.do","");
        urlMap.put("/invitingAgent.do","");
        urlMap.put("/applyAgent.do","");
        urlMap.put("/showCollege.do","");
        urlMap.put("//getUsers.do.do","");
        System.out.println("SystemFilter init");
    }

}
