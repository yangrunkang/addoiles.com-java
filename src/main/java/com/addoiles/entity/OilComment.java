package com.addoiles.entity;

public class OilComment {
    /**
     *
     * This field corresponds to the database column oil_comment.id
     *
     *
     */
    private String id;

    /**
     *
     * This field corresponds to the database column oil_comment.comment_id
     *
     *
     */
    private String comment_id;

    /**
     *
     * This field corresponds to the database column oil_comment.delete_status
     *
     *
     */
    private Integer delete_status;

    /**
     * This field corresponds to the database column oil_comment.user_id
     */
    private String user_id;

    /**
     * This field corresponds to the database column oil_comment.create_time
     */
    private Integer create_time;

    /**
     * This method returns the value of the database column oil_comment.id
     * @return the value of oil_comment.id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * This method sets the value of the database column oil_comment.id
     *
     * @param id the value for oil_comment.id
     *
     *
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * This method returns the value of the database column oil_comment.comment_id
     *
     * @return the value of oil_comment.comment_id
     *
     *
     */
    public String getComment_id() {
        return comment_id;
    }

    /**
     *
     * This method sets the value of the database column oil_comment.comment_id
     *
     * @param comment_id the value for oil_comment.comment_id
     *
     *
     */
    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    /**
     *
     * This method returns the value of the database column oil_comment.delete_status
     *
     * @return the value of oil_comment.delete_status
     *
     *
     */
    public Integer getDelete_status() {
        return delete_status;
    }

    /**
     *
     * This method sets the value of the database column oil_comment.delete_status
     *
     * @param delete_status the value for oil_comment.delete_status
     *
     *
     */
    public void setDelete_status(Integer delete_status) {
        this.delete_status = delete_status;
    }

    /**
     *
     * This method returns the value of the database column oil_comment.user_id
     *
     * @return the value of oil_comment.user_id
     *
     *
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     *
     * This method sets the value of the database column oil_comment.user_id
     *
     * @param user_id the value for oil_comment.user_id
     *
     *
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * This method returns the value of the database column oil_comment.create_time
     *
     * @return the value of oil_comment.create_time
     *
     *
     */
    public Integer getCreate_time() {
        return create_time;
    }

    /**
     *
     * This method sets the value of the database column oil_comment.create_time
     *
     * @param create_time the value for oil_comment.create_time
     *
     *
     */
    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }
}