package com.addoiles.dto.view;

import com.addoiles.entity.Article;

import java.util.List;

/**
 * 简化列表的Dto
 */
public class SimpleListDto {

    /**
     * 总数
     */
    private Integer totalCount;

    /**
     * 文章列表
     */
    private List<Article> articleList;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
