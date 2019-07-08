package zzgs.servlet;

import zzgs.Service.UserService;
import zzgs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> list =userService.getListAll();
        request.setAttribute("list",list);
//        if(list!=null && list.size()>0){
//            for (User user : list) {
//                System.out.println(user);
//            }
//        }
        request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);
    }
}
