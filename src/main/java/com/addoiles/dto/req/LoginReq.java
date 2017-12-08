package com.addoiles.dto.req;

import java.io.Serializable;

/**
 * Created by bla on 10/2/2017.
 */
public class LoginReq implements Serializable {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
