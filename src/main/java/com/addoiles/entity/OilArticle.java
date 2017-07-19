package com.addoiles.entity;

/**
 * 文章
 */
public class OilArticle {

    private String id;

    /**
     * 文章ID
     */
    private String articleId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 1-梦想 2-经历 3-最近难点 4-吐槽
     */
    private Integer type;

    /**
     * 0-删除 1-正常
     */
    private Integer deleteStatus;

    /**
     * 喜爱
     */
    private Integer favourite;

    /**
     * 创建时间
     */
    private Integer createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }


    public void setType(Integer type) {
        this.type = type;
    }


    public Integer getDeleteStatus() {
        return deleteStatus;
    }


    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public Integer getFavourite() {
        return favourite;
    }

    public void setFavourite(Integer favourite) {
        this.favourite = favourite;
    }


    public Integer getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}