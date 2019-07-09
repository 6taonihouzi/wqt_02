package zzgs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/userServlet")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request =(HttpServletRequest)req;
        //1.获取资源请求路径
        String uri =request.getRequestURI();
        //2.判断是否包含登录相关的资源
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")
                ||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/checkCodeServlet")) {
            //放行
            chain.doFilter(req, resp);
        }else {
            //3.获取session中的值
           Object login = request.getSession().getAttribute("login");
           if(login!=null)
           {
               //4.放行
               chain.doFilter(req, resp);
           }else
           {
               //没登录，去登录
               request.setAttribute("login_msg","没登录，去登录。");
               request.getRequestDispatcher("/jsp/login.jsp").forward(request,resp);
           }
        }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
