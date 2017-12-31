package com.addoiles.dto;

import java.io.Serializable;

/**
 * Created by bla on 10/3/2017.
 */
public class RegisterReq implements Serializable {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 邮件
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
