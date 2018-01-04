package com.addoiles.entity;

import java.io.Serializable;

/**
 * 问题
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/1/4 18:09
 */
public class Question implements Serializable {

    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 内容
     */
    private String content;

    /**
     * 问题类型 0-编程语言 1-开发问题 2-缓存技术 3-操作系统 4-学习
     */
    private Integer type;

    /**
     * 删除状态 0-正常 1-删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Integer createTime;

    /*****非表字段*****/
    /**
     * 用户名
     */
    private String userName;

    /**
     * 部分内容 非库字段
     */
//    private String partContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    public String getPartContent() {
//        return partContent;
//    }
//
//    public void setPartContent(String partContent) {
//        this.partContent = partContent;
//    }
}