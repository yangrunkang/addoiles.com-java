package com.addoiles.entity;


public class Experience {

    private Integer id;

    /**
     *   经历id
     */
    private String experienceId;

    /**
     *   用户id
     */
    private String userId;

    /**
     *   经历标题
     */
    private String title;

    /**
     *   经历内容
     */
    private String content;

    /**
     *   评分
     */
    private Integer rates;

    /**
     *   删除状态 0-正常 1-删除
     */
    private Integer deleteStatus;

    /**
     *   创建时间
     */
    private Integer createTime;

    /**
     *
     *  experience.id
     *
     * @return the value of experience.id
     *
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     *  experience.id
     *
     * @param id the value for experience.id
     *
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     *  experience.experience_id
     *
     * @return the value of experience.experience_id
     *
     *
     */
    public String getExperienceId() {
        return experienceId;
    }

    /**
     *
     *  experience.experience_id
     *
     * @param experienceId the value for experience.experience_id
     *
     *
     */
    public void setExperienceId(String experienceId) {
        this.experienceId = experienceId;
    }

    /**
     *
     *  experience.user_id
     *
     * @return the value of experience.user_id
     *
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     *  experience.user_id
     *
     * @param userId the value for experience.user_id
     *
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     *  experience.title
     *
     * @return the value of experience.title
     *
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     *  experience.title
     *
     * @param title the value for experience.title
     *
     *
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     *  experience.content
     *
     * @return the value of experience.content
     *
     *
     */
    public String getContent() {
        return content;
    }

    /**
     *
     *  experience.content
     *
     * @param content the value for experience.content
     *
     *
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     *  experience.rates
     *
     * @return the value of experience.rates
     *
     *
     */
    public Integer getRates() {
        return rates;
    }

    /**
     *
     *  experience.rates
     *
     * @param rates the value for experience.rates
     *
     *
     */
    public void setRates(Integer rates) {
        this.rates = rates;
    }

    /**
     *
     *  experience.delete_status
     *
     * @return the value of experience.delete_status
     *
     *
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *
     *  experience.delete_status
     *
     * @param deleteStatus the value for experience.delete_status
     *
     *
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     *
     *  experience.create_time
     *
     * @return the value of experience.create_time
     *
     *
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     *
     *  experience.create_time
     *
     * @param createTime the value for experience.create_time
     *
     *
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}