package com.addoiles.dto.resp;

import com.addoiles.entity.*;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/6/28 14:45
 */
public class LatestResp implements Serializable {

    /**
     * 文章列表
     */
    private List<Article> articleList;

    /**
     * 微内容
     */
    private List<MicroContent> microContentList;

    /**
     * 建议及反馈
     */
    private List<Suggest> suggestList;

    /**
     * 问题列表
     */
    private List<Question> questionList;


    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<MicroContent> getMicroContentList() {
        return microContentList;
    }

    public void setMicroContentList(List<MicroContent> microContentList) {
        this.microContentList = microContentList;
    }

    public List<Suggest> getSuggestList() {
        return suggestList;
    }

    public void setSuggestList(List<Suggest> suggestList) {
        this.suggestList = suggestList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

}
