package com.addoiles.entity;


public class Dreams {
    /**
     *
     *
     *  dreams.id
     *
     *
     */
    private Integer id;

    /**
     *
     *   梦想id
     *
     *
     *  dreams.dream_id
     *
     *
     */
    private String dreamId;

    /**
     *
     *   用户id
     *
     *
     *  dreams.user_id
     *
     *
     */
    private String userId;

    /**
     *
     *   梦想标题
     *
     *
     *  dreams.title
     *
     *
     */
    private String title;

    /**
     *
     *   梦想内容
     *
     *
     *  dreams.content
     *
     *
     */
    private String content;

    /**
     *
     *   点赞数
     *
     *
     *  dreams.likes
     *
     *
     */
    private Integer likes;

    /**
     *
     *   删除状态 0-正常 1-删除
     *
     *
     *  dreams.delete_status
     *
     *
     */
    private Integer deleteStatus;

    /**
     *
     *   创建时间
     *
     *
     *  dreams.create_time
     *
     *
     */
    private Integer createTime;

    /**
     *
     *  dreams.id
     *
     * @return the value of dreams.id
     *
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     *  dreams.id
     *
     * @param id the value for dreams.id
     *
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     *  dreams.dream_id
     *
     * @return the value of dreams.dream_id
     *
     *
     */
    public String getDreamId() {
        return dreamId;
    }

    /**
     *
     *  dreams.dream_id
     *
     * @param dreamId the value for dreams.dream_id
     *
     *
     */
    public void setDreamId(String dreamId) {
        this.dreamId = dreamId;
    }

    /**
     *
     *  dreams.user_id
     *
     * @return the value of dreams.user_id
     *
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     *  dreams.user_id
     *
     * @param userId the value for dreams.user_id
     *
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     *  dreams.title
     *
     * @return the value of dreams.title
     *
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     *  dreams.title
     *
     * @param title the value for dreams.title
     *
     *
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     *  dreams.content
     *
     * @return the value of dreams.content
     *
     *
     */
    public String getContent() {
        return content;
    }

    /**
     *
     *  dreams.content
     *
     * @param content the value for dreams.content
     *
     *
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     *  dreams.likes
     *
     * @return the value of dreams.likes
     *
     *
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     *
     *  dreams.likes
     *
     * @param likes the value for dreams.likes
     *
     *
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     *
     *  dreams.delete_status
     *
     * @return the value of dreams.delete_status
     *
     *
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *
     *  dreams.delete_status
     *
     * @param deleteStatus the value for dreams.delete_status
     *
     *
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     *
     *  dreams.create_time
     *
     * @return the value of dreams.create_time
     *
     *
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     *
     *  dreams.create_time
     *
     * @param createTime the value for dreams.create_time
     *
     *
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}