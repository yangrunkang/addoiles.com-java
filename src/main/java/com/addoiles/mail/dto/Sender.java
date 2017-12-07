package com.addoiles.mail.dto;

/**
 * Description:发送者
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 15:21
 */
public class Sender {

    /**
     * 发送者名称
     */
    private String name;

    /**
     * 发送者邮件地址
     */
    private String emailAddress;

    /**
     * 发送者邮箱授权码
     * @apiNote 如果验证不通过,需要重新申请
     */
    // TODO: 2017/12/7 配置文件配置 ratrlqxcsupyhfid
    private String authorizationCode;


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

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }
}
