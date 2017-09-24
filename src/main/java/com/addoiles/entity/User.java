package com.addoiles.entity;

public class User {
    /**
     *
     *
     *  user.id
     *
     *
     */
    private Integer id;

    /**
     *
     *   用户id
     *
     *
     *  user.user_id
     *
     *
     */
    private String userId;

    /**
     *
     *   用户名
     *
     *
     *  user.name
     *
     *
     */
    private String name;

    /**
     *
     *   用户名密码
     *
     *
     *  user.password
     *
     *
     */
    private String password;

    /**
     *
     *   用户邮箱
     *
     *
     *  user.email
     *
     *
     */
    private String email;

    /**
     *
     *   删除状态 0-正常 1-删除
     *
     *
     *  user.delete_status
     *
     *
     */
    private Integer deleteStatus;

    /**
     *
     *   创建时间
     *
     *
     *  user.create_time
     *
     *
     */
    private Integer createTime;

    /**
     *
     *  user.id
     *
     * @return the value of user.id
     *
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     *  user.id
     *
     * @param id the value for user.id
     *
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     *  user.user_id
     *
     * @return the value of user.user_id
     *
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     *  user.user_id
     *
     * @param userId the value for user.user_id
     *
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     *  user.name
     *
     * @return the value of user.name
     *
     *
     */
    public String getName() {
        return name;
    }

    /**
     *
     *  user.name
     *
     * @param name the value for user.name
     *
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     *  user.password
     *
     * @return the value of user.password
     *
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     *  user.password
     *
     * @param password the value for user.password
     *
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     *  user.email
     *
     * @return the value of user.email
     *
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     *  user.email
     *
     * @param email the value for user.email
     *
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     *  user.delete_status
     *
     * @return the value of user.delete_status
     *
     *
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *
     *  user.delete_status
     *
     * @param deleteStatus the value for user.delete_status
     *
     *
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     *
     *  user.create_time
     *
     * @return the value of user.create_time
     *
     *
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     *
     *  user.create_time
     *
     * @param createTime the value for user.create_time
     *
     *
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}