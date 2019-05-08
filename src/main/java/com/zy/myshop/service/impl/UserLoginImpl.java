package com.zy.myshop.service.impl;

import com.zy.myshop.comment.until.MyApplicationContext;
import com.zy.myshop.dao.impl.GetUserImpl;
import com.zy.myshop.entity.User;
import com.zy.myshop.service.UserLogin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


@Service(value = "userLoginimpl")
public class UserLoginImpl implements UserLogin {
    public User login(String name,String password,Boolean remember,Boolean autoLogin) {
        //GetUserImpl getuserImpl = (GetUserImpl) MyApplicationContext.applicationContext.getBean("getuserImpl");

        GetUserImpl getuserImpl1 = MyApplicationContext.getBean("getuserImpl");
        User user = getuserImpl1.getUser(name, password);
        if (user!=null){
            for (User u:UserList.userList){
                if (u.getUsername()==user.getUsername()){
                    u.setAutoLogin(autoLogin);
                    u.setRememberpwd(remember);
                    return u;
                }
            }
            user.setAutoLogin(autoLogin);
            user.setRememberpwd(remember);
            UserList.userList.add(user);
        }
        return user;
    }
}
