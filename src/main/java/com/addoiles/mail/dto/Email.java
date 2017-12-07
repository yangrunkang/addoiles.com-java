package com.addoiles.mail.dto;

/**
 * Description: 邮件
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 15:29
 */
public class Email {

    /**
     * 发送者
     */
    private Sender sender;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件主题
     */
    private String content;

    /**
     * 接收者
     */
    private Receiver receiver;

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

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

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
