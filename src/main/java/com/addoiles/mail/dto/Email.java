package com.addoiles.mail.dto;

/**
 * Description: 邮件
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 15:29
 */
public class Email {

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 接收者
     */
    private Receiver receiver;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
