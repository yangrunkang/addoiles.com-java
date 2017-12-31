package com.addoiles.impl;

import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.Article;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   9/24/2017 15:17
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getList(QueryDto queryDto) {
        return articleMapper.getList(queryDto);
    }



    @OilLog
    @Override
    public Integer insert(Article article) {
        article.setArticleId(OilUtils.generateID());
        article.setRates(0);
        article.setRateCount(0);
        article.setCreateTime(TimeUtil.currentTime());
        return articleMapper.insert(article);
    }

    @Override
    public Article getByBusinessId(String businessId) {
        return articleMapper.getByBusinessId(businessId);
    }


    @OilLog
    @Override
    public Integer update(Article article) {
        article.setUpdateTime(TimeUtil.currentTime());
        return articleMapper.update(article);
    }


    @OilLog
    @Override
    public Integer delete(String articleId) {
        return articleMapper.delete(articleId);
    }

    @Override
    public List<Article> getSimpleList(QueryDto queryDto) {
        return articleMapper.getSimpleList(queryDto);
    }
}
