package zzgs.servlet;

import zzgs.Service.loginService;
import zzgs.entity.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String name = request.getParameter("name");
        String password =request.getParameter("password");
        String ipassword =request.getParameter("Ipassword");
        if( name == ""||password==""||ipassword=="")
        {
            //错误消息
            request.setAttribute("register_msg","三项不能为空");
            //跳转页面
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            return;
        }
        //对比俩次密码是否一致
        if(!password.equals(ipassword))
        {
            //错误消息
            request.setAttribute("register_msg","俩次密码输入不一致,请重新输入");
            //跳转页面
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            return;
        }
        //3.封装对象
        login lo =new login();
        lo.setName_login(name);
        lo.setPassword_login(password);
        //4.调用Serivce
        loginService ls = new loginService();
        ls.addlogin(lo);
        //5.跳转页面
        PrintWriter out = response.getWriter();
        out.print("<script>alert('注册成功');</script>");
        request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
