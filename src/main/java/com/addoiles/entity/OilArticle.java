package com.addoiles.entity;

public class OilArticle {

    private String id;

    private String articleId;

    private String userId;

    private String title;

    private String content;

    private Integer type;

    private Integer deleteStatus;

    private Integer favourite;

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