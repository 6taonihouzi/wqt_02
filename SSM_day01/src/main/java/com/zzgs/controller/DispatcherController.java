package com.zzgs.controller;

import com.zzgs.domain.UserLogin;
import com.zzgs.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class DispatcherController {
     @Autowired
     UserLoginServiceImpl userloginService;

     @RequestMapping("/logout")
     public String logout(HttpSession session) {
         session.invalidate();//使session失效
         return "login";//返回登录页面
     }
     @RequestMapping("/login")
     public String login(){
       return "login";
     }

     @RequestMapping("/dologin")
     @ResponseBody
     public ModelAndView doLogin(HttpSession session, UserLogin userLogin){
         ModelAndView model = new ModelAndView();
         String nameLogin = userLogin.getName_login();
         String passwordLogin = userLogin.getPassword_login();
         UserLogin user = userloginService.findByUserName(nameLogin, passwordLogin);
         if("".equals(user)||user==null)
         {
             session.setAttribute("warn","账号或者密码错误!");
             model.setViewName("login");
             return model;
         }else{
             session.setAttribute("userlogin",user);
             model.setViewName("mainTemp");
             return model;
         }
     }
}
