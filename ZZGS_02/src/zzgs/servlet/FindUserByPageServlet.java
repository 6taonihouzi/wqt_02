package zzgs.servlet;

import zzgs.Service.UserService;
import zzgs.entity.Pagebean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentpage = request.getParameter("currentpage");
        String rows =request.getParameter("rows");
        if(currentpage==null|"".equals(currentpage))
        {
            currentpage="1";
        }
        if(rows==null|"".equals(rows))
        {
            rows="5";
        }
        //2.调用Service
        UserService userService =new UserService();
        Pagebean pb = userService.findUserByPage(currentpage,rows);
        //3.将PageBean存入Request中
        request.setAttribute("pb",pb);
        //4.传入到主页面
        request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
