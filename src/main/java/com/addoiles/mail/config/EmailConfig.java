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


    /**
     * 主题字符编码
     */
    private String subjectCharset;

    /**
     * 内容字符编码
     */
    private String contentCharset;

    /**
     * 发件人/收件人姓名字符编码
     */
    private String personalCharset;



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

    public String getSubjectCharset() {
        return subjectCharset;
    }

    public void setSubjectCharset(String subjectCharset) {
        this.subjectCharset = subjectCharset;
    }

    public String getContentCharset() {
        return contentCharset;
    }

    public void setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
    }

    public String getPersonalCharset() {
        return personalCharset;
    }

    public void setPersonalCharset(String personalCharset) {
        this.personalCharset = personalCharset;
    }
}
