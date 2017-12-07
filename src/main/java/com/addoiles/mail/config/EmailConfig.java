package com.addoiles.mail.config;

/**
 * Description: 邮箱基本配置
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 15:28
 */
public class EmailConfig {

    /**
     * 传输协议
     */
    private String transportProtocol;

    /**
     * 邮件服务器请求地址
     * smtp
     */
    private String mailHost;

    /**
     * 邮件服务器端口
     */
    private String mailHostPort;

    /**
     * 是否请求请求验证
     * "true" or "false"
     */
    private String isMailAuth;



    public String getTransportProtocol() {
        return transportProtocol;
    }

    public void setTransportProtocol(String transportProtocol) {
        this.transportProtocol = transportProtocol;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getIsMailAuth() {
        return isMailAuth;
    }

    public void setIsMailAuth(String isMailAuth) {
        this.isMailAuth = isMailAuth;
    }

    public String getMailHostPort() {
        return mailHostPort;
    }

    public void setMailHostPort(String mailHostPort) {
        this.mailHostPort = mailHostPort;
    }
}
