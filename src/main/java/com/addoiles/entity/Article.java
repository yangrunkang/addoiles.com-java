package com.addoiles.entity;

/**
 *  文章
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/1/4 18:09
 */
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
     * 文章是否隐藏 0-公开 1-隐藏
     */
    private Integer isHide;

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


    /********非表字段***********/
    /**
     * 用户名
     */
    private String userName;

    /**
     * 部分内容 非库字段
     */
//    private String partContent;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }


    public Integer getArticleType() {
        return articleType;
    }


    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
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


    public String getContent() {
        return content;
    }


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

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getPartContent() {
//        return partContent;
//    }
//
//    public void setPartContent(String partContent) {
//        this.partContent = partContent;
//    }
}