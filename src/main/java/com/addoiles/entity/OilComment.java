package com.addoiles.entity;

/**
 * 所有评论相关
 */
public class OilComment {

    private String id;

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 0-删除 1-正常
     */
    private Integer deleteStatus;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 创建时间
     */
    private Integer createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }


    public Integer getDeleteStatus() {
        return deleteStatus;
    }


    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}