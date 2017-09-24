package com.addoiles.entity;


public class Comment {
    /**
     *
     *
     *  comment.id
     *
     *
     */
    private Integer id;

    /**
     *
     *   评论id
     *
     *
     *  comment.commit_id
     *
     *
     */
    private String commitId;

    /**
     *
     *   用户id
     *
     *
     *  comment.user_id
     *
     *
     */
    private String userId;

    /**
     *
     *   被评论内容的id
     *
     *
     *  comment.target_id
     *
     *
     */
    private String targetId;

    /**
     *
     *   评论内容
     *
     *
     *  comment.content
     *
     *
     */
    private String content;

    /**
     *
     *   删除状态 0-正常 1-删除
     *
     *
     *  comment.delete_status
     *
     *
     */
    private Integer deleteStatus;

    /**
     *
     *   创建时间
     *
     *
     *  comment.create_time
     *
     *
     */
    private Integer createTime;

    /**
     *
     *  comment.id
     *
     * @return the value of comment.id
     *
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     *  comment.id
     *
     * @param id the value for comment.id
     *
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     *  comment.commit_id
     *
     * @return the value of comment.commit_id
     *
     *
     */
    public String getCommitId() {
        return commitId;
    }

    /**
     *
     *  comment.commit_id
     *
     * @param commitId the value for comment.commit_id
     *
     *
     */
    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    /**
     *
     *  comment.user_id
     *
     * @return the value of comment.user_id
     *
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     *  comment.user_id
     *
     * @param userId the value for comment.user_id
     *
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     *  comment.target_id
     *
     * @return the value of comment.target_id
     *
     *
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     *
     *  comment.target_id
     *
     * @param targetId the value for comment.target_id
     *
     *
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     *
     *  comment.content
     *
     * @return the value of comment.content
     *
     *
     */
    public String getContent() {
        return content;
    }

    /**
     *
     *  comment.content
     *
     * @param content the value for comment.content
     *
     *
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     *  comment.delete_status
     *
     * @return the value of comment.delete_status
     *
     *
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *
     *  comment.delete_status
     *
     * @param deleteStatus the value for comment.delete_status
     *
     *
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     *
     *  comment.create_time
     *
     * @return the value of comment.create_time
     *
     *
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     *
     *  comment.create_time
     *
     * @param createTime the value for comment.create_time
     *
     *
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}