package com.addoiles.entity;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/8/3 20:45
 */
public class OilText {


    private String id;

    /**
     * 文章ID
     */
    private String articleId;


    /**
     * 超长文本
     */
    private String content;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
