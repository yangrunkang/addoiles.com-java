package com.addoiles.dto.req;

import java.io.Serializable;

/**
 * Description: 验证码请求对象
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 10:34
 */
public class VerificationCodeReq implements Serializable {

    /**
     * 邮件类型 1. 忘记密码找回邮件  2.新用户注册邮件
     */
    private Integer type;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
