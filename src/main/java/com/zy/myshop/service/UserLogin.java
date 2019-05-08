package com.zy.myshop.service;

import com.zy.myshop.entity.User;

public interface UserLogin {
    public User login(String user, String password,Boolean remember,Boolean autoLogin);
}
