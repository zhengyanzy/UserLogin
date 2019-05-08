package com.zy.myshop.web.controller;

import com.zy.myshop.comment.until.MyApplicationContext;
import com.zy.myshop.entity.User;
import com.zy.myshop.service.impl.UserIndexImpl;
import com.zy.myshop.service.impl.UserLoginImpl;
import com.zy.myshop.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登录。。。。。");
        String auto = CookieUtils.getCookieValue(req, "auto");
        if ("1".equals(auto)){
            resp.sendRedirect("/home.jsp");
            return;
        }
        String userInfo = CookieUtils.getCookieValue(req, "UserInfo");
        System.out.println(!StringUtils.isBlank(userInfo)+"----");
        if (!StringUtils.isBlank(userInfo)){
            String[] split = userInfo.split(":");
            String username = split[0];
            String password = split[1];
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("checked","checked");
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        return;
    }
}
