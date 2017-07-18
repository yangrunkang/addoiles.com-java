package com.addoiles.entity;

public class OilShare {
    /**
     *
     * This field corresponds to the database column oil_share.id
     *
     *
     */
    private String id;

    /**
     *
     * This field corresponds to the database column oil_share.title
     *
     *
     */
    private String title;

    /**
     *
     * This field corresponds to the database column oil_share.content
     *
     *
     */
    private String content;

    /**
     *
     * This field corresponds to the database column oil_share.favorite
     *
     *
     */
    private Integer favorite;

    /**
     *
     * This field corresponds to the database column oil_share.dislike
     *
     *
     */
    private Integer dislike;

    /**
     *
     * This field corresponds to the database column oil_share.delete_status
     *
     *
     */
    private Integer delete_status;

    /**
     *
     * This method returns the value of the database column oil_share.id
     *
     * @return the value of oil_share.id
     *
     *
     */
    public String getId() {
        return id;
    }

    /**
     *
     * This method sets the value of the database column oil_share.id
     *
     * @param id the value for oil_share.id
     *
     *
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * This method returns the value of the database column oil_share.title
     *
     * @return the value of oil_share.title
     *
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * This method sets the value of the database column oil_share.title
     *
     * @param title the value for oil_share.title
     *
     *
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * This method returns the value of the database column oil_share.content
     *
     * @return the value of oil_share.content
     *
     *
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * This method sets the value of the database column oil_share.content
     *
     * @param content the value for oil_share.content
     *
     *
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * This method returns the value of the database column oil_share.favorite
     *
     * @return the value of oil_share.favorite
     *
     *
     */
    public Integer getFavorite() {
        return favorite;
    }

    /**
     *
     * This method sets the value of the database column oil_share.favorite
     *
     * @param favorite the value for oil_share.favorite
     *
     *
     */
    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    /**
     *
     * This method returns the value of the database column oil_share.dislike
     *
     * @return the value of oil_share.dislike
     *
     *
     */
    public Integer getDislike() {
        return dislike;
    }

    /**
     *
     * This method sets the value of the database column oil_share.dislike
     *
     * @param dislike the value for oil_share.dislike
     *
     *
     */
    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    /**
     *
     * This method returns the value of the database column oil_share.delete_status
     *
     * @return the value of oil_share.delete_status
     *
     *
     */
    public Integer getDelete_status() {
        return delete_status;
    }

    /**
     *
     * This method sets the value of the database column oil_share.delete_status
     *
     * @param delete_status the value for oil_share.delete_status
     *
     *
     */
    public void setDelete_status(Integer delete_status) {
        this.delete_status = delete_status;
    }
}