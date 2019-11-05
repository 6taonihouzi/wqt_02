package com.zzgs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if(uri.contains("/css/")||uri.contains("/js/")||uri.contains("/images/")||uri.contains("/common/")
                ||uri.contains("/login.jsp")||uri.contains("/newType/")){
            //放行
            chain.doFilter(req, resp);
        }else {
            //获取session中的值
            Object login = request.getSession().getAttribute("userlogin");
            if(login!=null&&!"".equals(login))
            {
                //放行
                chain.doFilter(req, resp);
            }else
            {
                //没登录，去登录
                request.getRequestDispatcher("/login").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
