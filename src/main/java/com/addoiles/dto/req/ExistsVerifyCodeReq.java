package com.addoiles.dto.req;

import java.io.Serializable;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 15:19
 */
public class ExistsVerifyCodeReq implements Serializable {

    private String email;

    private String code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
