package com.zy.myshop.service.impl;

import com.zy.myshop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserIndexImpl {
    public User index(String name){
        List<User> userList = UserList.userList;
        for (User u:userList){
            System.out.println("u.getUsername()->"+u.getUsername());
            if (u.getUsername().equals(name)){
                System.out.println("获取到user了");
                return u;
            }
        }
        return null;
    }
}
