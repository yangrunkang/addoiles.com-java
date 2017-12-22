package com.addoiles.entity;

@Deprecated
public class Hots {

    private Integer id;

    /**
     * 热门id
     */
    private String hotId;

    /**
     * 用户id(可以为空)
     */
    private String userId;

    /**
     * 热门动弹标题
     */
    private String title;

    /**
     * 热门动弹内容
     */
    private String content;

    /**
     * 删除状态 0-正常 1-删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * hots.id
     *
     * @return the value of hots.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * hots.id
     *
     * @param id the value for hots.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * hots.hot_id
     *
     * @return the value of hots.hot_id
     */
    public String getHotId() {
        return hotId;
    }

    /**
     * hots.hot_id
     *
     * @param hotId the value for hots.hot_id
     */
    public void setHotId(String hotId) {
        this.hotId = hotId;
    }

    /**
     * hots.user_id
     *
     * @return the value of hots.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * hots.user_id
     *
     * @param userId the value for hots.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * hots.title
     *
     * @return the value of hots.title
     */
    public String getTitle() {
        return title;
    }

    /**
     * hots.title
     *
     * @param title the value for hots.title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * hots.content
     *
     * @return the value of hots.content
     */
    public String getContent() {
        return content;
    }

    /**
     * hots.content
     *
     * @param content the value for hots.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * hots.delete_status
     *
     * @return the value of hots.delete_status
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * hots.delete_status
     *
     * @param deleteStatus the value for hots.delete_status
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * hots.create_time
     *
     * @return the value of hots.create_time
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * hots.create_time
     *
     * @param createTime the value for hots.create_time
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}