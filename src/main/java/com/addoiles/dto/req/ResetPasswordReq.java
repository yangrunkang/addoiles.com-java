package com.addoiles.dto.req;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 15:43
 */
public class ResetPasswordReq {

    private String email;

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
