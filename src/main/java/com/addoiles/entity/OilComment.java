package com.addoiles.entity;

/**
 * 所有评论相关
 */
public class OilComment {

    private String id;

    /**
     * 文章ID
     */
    private String articleId;

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 0-删除 1-正常
     */
    private Integer deleteStatus;

    /**
     * 用户ID
     */
    private String userId;

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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }


    public Integer getDeleteStatus() {
        return deleteStatus;
    }


    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}