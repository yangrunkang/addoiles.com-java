package com.addoiles.dto;

import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;

import java.util.List;

/**
 * 技术沉淀Dto
 * Created by bla on 10/1/2017.
 */
public class ITTechDto {

    /**
     * 简洁文章列表
     */
    private List<Article> pithinessList;

    /**
     * 默认展示文章列表的一个详情
     */
    private Article article;

    /**
     * 详情文章评论列表
     */
    private List<Comment> articleCommentList;

    public List<Article> getPithinessList() {
        return pithinessList;
    }

    public void setPithinessList(List<Article> pithinessList) {
        this.pithinessList = pithinessList;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Comment> getArticleCommentList() {
        return articleCommentList;
    }

    public void setArticleCommentList(List<Comment> articleCommentList) {
        this.articleCommentList = articleCommentList;
    }
}
