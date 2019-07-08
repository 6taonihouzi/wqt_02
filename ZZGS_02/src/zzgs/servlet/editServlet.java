package zzgs.servlet;

import zzgs.Service.UserService;
import zzgs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        UserService userService =new UserService();
        //3.将user存入request
        User user = null;
        user = userService.getdateById(Integer.parseInt(id));
        request.setAttribute("user",user);
        //4.转发到edit.jsp页面
        request.getRequestDispatcher("/jsp/edit.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
