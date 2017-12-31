package com.addoiles.entity;

import java.io.Serializable;

/**
 *  微内容
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/22 16:33
 */
public class MicroContent implements Serializable {
    private Integer id;

    /**
     * 微内容id
     */
    private String microId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 微内容类型 0-热门动弹 1-梦想
     */
    private Integer microType;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 删除状态 0-正常 1-删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Integer createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMicroId() {
        return microId;
    }

    public void setMicroId(String microId) {
        this.microId = microId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMicroType() {
        return microType;
    }

    public void setMicroType(Integer microType) {
        this.microType = microType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }


}