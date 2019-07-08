package zzgs.servlet;

import zzgs.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.获取id
        String id = request.getParameter("id");
       //2.调用service
        UserService userService =new UserService();
        userService.delete(Integer.parseInt(id));
        //3.调转页面
       response.sendRedirect(request.getContextPath()+"/userServlet");
       //request.getRequestDispatcher("/userServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
