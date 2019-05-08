package com.zy.myshop.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private Boolean autoLogin;
    private Boolean rememberpwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(Boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    public Boolean getRememberpwd() {
        return rememberpwd;
    }

    public void setRememberpwd(Boolean rememberpwd) {
        this.rememberpwd = rememberpwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", autoLogin=" + autoLogin +
                ", rememberpwd=" + rememberpwd +
                '}';
    }
}
