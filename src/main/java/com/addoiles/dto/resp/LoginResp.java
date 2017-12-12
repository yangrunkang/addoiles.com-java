package com.addoiles.dto.resp;

import java.io.Serializable;

/**
 * Created by bla on 10/2/2017.
 */
public class LoginResp implements Serializable {


    private String userId;

    private String userName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
