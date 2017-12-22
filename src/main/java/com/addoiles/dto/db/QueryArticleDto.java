package com.addoiles.dto.db;

import com.addoiles.common.Page;

/**
 * Description: 查询文章Dto
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/22 17:21
 */

public class QueryArticleDto {

    private Page page;

    private String userId;

    private Integer articleType;

    private String articleId;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
