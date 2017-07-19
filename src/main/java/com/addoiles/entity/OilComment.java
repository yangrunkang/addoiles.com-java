package com.addoiles.entity;

public class OilComment {

    private String id;

    private String commentId;

    private Integer deleteStatus;

    private String userId;

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