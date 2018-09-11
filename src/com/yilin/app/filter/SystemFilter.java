package com.yilin.app.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cc on 2018/7/12.
 */
public class SystemFilter implements Filter {


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
        if(url.indexOf("login") != -1 || url.indexOf("toLogin") != -1 || url.indexOf("invitingAgent") != -1|| url.indexOf("applyAgent") != -1){
            arg2.doFilter(arg0, arg1);
            return;
        }
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            arg2.doFilter(arg0, arg1);
        }else {
            request.getRequestDispatcher("/system/login.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("SystemFilter init");
    }

}
