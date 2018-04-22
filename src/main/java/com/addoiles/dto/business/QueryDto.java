package com.addoiles.dto.business;

import com.addoiles.common.Page;

/**
 * Description: Base查询对象
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/25 14:58
 */
public class QueryDto {

    /**
     * 分页对象
     */
    private Page page;

    /**
     * 用户id
     */
    private String userId;

    /**
     * tokenId
     */
    private String tokenId;

    /**
     * 排序规则
     * 1-更新时间倒叙
     */
    private Integer sortBy;

    /**
     * 业务id
     * 除表id外的实体id,比如User表中的userId,Article表的articleId
     *
     * @return
     */
    private String businessId;

    /*微内容业务********************************/
    /**
     * 微内容类型 0-热门动弹 1-梦想
     */
    private Integer microType;


    /*文章业务********************************/
    /**
     * 文章类型 0-经历分享 1-软件评测 2-技术沉淀
     */
    private Integer articleType;

    /**
     * 问题类型 0-编程语言 1-开发问题 2-缓存技术 3-操作系统 4-学习
     */
    private Integer questionType;


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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getMicroType() {
        return microType;
    }

    public void setMicroType(Integer microType) {
        this.microType = microType;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
