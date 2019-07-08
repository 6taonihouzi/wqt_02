package zzgs.servlet;

import zzgs.Service.UserService;
import zzgs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2获取参数
        String id =request.getParameter("id");
        String name=request.getParameter("username");
        String sex=request.getParameter("sex");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String palce=request.getParameter("palce");
        String create_time= request.getParameter("create_time");
        String modify_time= request.getParameter("modify_time");
        //3.封装对象
        User user =new User();
        user.setName(name);
        user.setSex(sex);
        user.setPalce(palce);
        user.setAge(age);
        user.setId(Integer.parseInt(id));
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            user.setCtrate_time(new Date(sdf.parse(create_time).getTime()));
            user.setModify_time(new Date(sdf.parse(modify_time).getTime()));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        //调用Service对象
        UserService userService =new UserService();
        userService.updateUser(user);
        //5跳转页面
        response.sendRedirect(request.getContextPath()+"/userServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
