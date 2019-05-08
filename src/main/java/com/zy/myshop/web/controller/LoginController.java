package com.zy.myshop.web.controller;

import com.zy.myshop.comment.until.MyApplicationContext;
import com.zy.myshop.entity.User;
import com.zy.myshop.service.impl.UserLoginImpl;
import com.zy.myshop.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("".equals(username)||"".equals(password)){
            System.out.println("用户名或密码为空");
            req.setAttribute("message","用户名或密码不能为空");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }else {
            Boolean remember = false;
            Boolean autoLogin = false;
            //记住密码
            System.out.println("req.getRequestDispatcher()-->"+req.getRequestDispatcher("cb")+"--"+req.getRequestDispatcher("cb2"));
            if (req.getParameter("cb")!=null){
                System.out.println("设置记住密码");
                remember = true;
            }
            //自动登录
            if (req.getParameter("cb2")!=null){
                System.out.println("设置自动登录");
                autoLogin = true;
            }
            //UserLoginImpl userLoginimpl = (UserLoginImpl) MyApplicationContext.applicationContext.getBean("userLoginimpl");
            UserLoginImpl userLoginimpl1 = MyApplicationContext.getBean("userLoginimpl");

            User user = userLoginimpl1.login(username, password,remember,autoLogin);
            //登录成功
            if(user!=null){
                //表示记住密码或者自动登录,才会给浏览器设置 cookie
                if(req.getParameter("cb")!=null){
                    System.out.println("设置cookie...");
                    CookieUtils.setCookie(req,resp,"UserInfo",String.format("%s:%s",username,password));
                }else {
                    CookieUtils.deleteCookie(req,resp,"UserInfo");
                }
                if (req.getParameter("cb2")!=null){
                    CookieUtils.setCookie(req,resp,"auto","1");
                }
                resp.sendRedirect("/home.jsp");
                return;
            }
            //登录失败
            else{
                System.out.println("登录失败");
                req.setAttribute("message","用户名或密码错误");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
        }
    }

}
