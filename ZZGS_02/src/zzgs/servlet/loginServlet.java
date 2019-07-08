package zzgs.servlet;

import zzgs.Service.loginService;
import zzgs.entity.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
             String vcode = request.getParameter("vscode");
             String name =  request.getParameter("name");
             String password =request.getParameter("password");
        //验证码校验
        HttpSession session = request.getSession();
        String codeValidate = (String) session.getAttribute("codeValidate");
        session.removeAttribute("codeValidate");//确保验证码一次性
        if(!codeValidate.equalsIgnoreCase(vcode))
        {
            //验证码错误消息
            request.setAttribute("login_msg","验证码错误!");
            //跳转页面
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            return;
        }
        //3.封装login
            login log = new login();
            log.setName_login(name);
            log.setPassword_login(password);
        //4.调用Service
        loginService loginservice = new loginService();
        login successlogin = loginservice.successlogin(name, password);
        //5.判断是否为登录成功
        if(successlogin!=null)
        {
            //登录成功
            //将用户存入session
            session.setAttribute("login",successlogin);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/userServlet");
        }
        else {
            //登录失败
            //错误消息
            request.setAttribute("login_msg","用户名或密码错误!");
            //跳转页面
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }
}
