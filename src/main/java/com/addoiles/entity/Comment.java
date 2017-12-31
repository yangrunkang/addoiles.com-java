package com.addoiles.entity;


public class Comment {
    private Integer id;

    /**
     *   评论id
     */
    private String commitId;

    /**
     *   用户id
     */
    private String userId;

    /**
     *   被评论内容的id
     */
    private String targetId;

    /**
     *   评论内容
     */
    private String content;

    /**
     *   删除状态 0-正常 1-删除
     */
    private Integer deleteStatus;

    /**
     *   创建时间
     */
    private Integer createTime;


    /******非表字段*******/
    /**
     * 用户名
     */
    private String userName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}