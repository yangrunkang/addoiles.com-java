package com.addoiles.mail.dto;

/**
 * Description: 邮件接收者
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 15:26
 */
public class Receiver {

    /**
     * 邮件接收者名称
     */
    private String name;

    /**
     * 邮件接收者邮箱地址
     */
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
