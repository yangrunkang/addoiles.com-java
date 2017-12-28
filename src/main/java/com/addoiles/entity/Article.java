package com.addoiles.entity;


public class Article {

    private Integer id;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 文章类型
     */
    private Integer articleType;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 评分
     */
    private Integer rates;

    /**
     * 评分次数
     */
    private Integer rateCount;


    /**
     * 删除状态 0-正常 1-删除 2-草稿
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 编辑时间
     */
    private Integer updateTime;

    /**
     * article.id
     *
     * @return the value of article.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * article.id
     *
     * @param id the value for article.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * article.article_id
     *
     * @return the value of article.article_id
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * article.article_id
     *
     * @param articleId the value for article.article_id
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * article.article_type
     *
     * @return the value of article.article_type
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * article.article_type
     *
     * @param articleType the value for article.article_type
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * article.title
     *
     * @return the value of article.title
     */
    public String getTitle() {
        return title;
    }

    /**
     * article.title
     *
     * @param title the value for article.title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * article.delete_status
     *
     * @return the value of article.delete_status
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * article.delete_status
     *
     * @param deleteStatus the value for article.delete_status
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * article.create_time
     *
     * @return the value of article.create_time
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * article.create_time
     *
     * @param createTime the value for article.create_time
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * article.content
     *
     * @return the value of article.content
     */
    public String getContent() {
        return content;
    }

    /**
     * article.content
     *
     * @param content the value for article.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRates() {
        return rates;
    }

    public void setRates(Integer rates) {
        this.rates = rates;
    }

    public Integer getRateCount() {
        return rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }
}