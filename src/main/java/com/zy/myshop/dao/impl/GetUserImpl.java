package com.zy.myshop.dao.impl;

import com.zy.myshop.dao.GetUser;
import com.zy.myshop.entity.User;
import org.springframework.stereotype.Repository;


@Repository(value = "getuserImpl")
public class GetUserImpl implements GetUser {
    public User getUser(String name, String password){
        User user = null;
        if("admin".equals(name)){
            if ("admin".equals(password)){
                user = new User();
                user.setUsername("admin");
                user.setPassword("admin");
                return user;
            }
        }
        return null;
    }
}
