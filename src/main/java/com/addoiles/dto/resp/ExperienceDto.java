package com.addoiles.dto.resp;

import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;

import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/28 11:08
 */

public class ExperienceDto {
    /**
     * 文章
     */
    private Article article;

    /**
     * 评论列表
     */
    private List<Comment> commentList;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
