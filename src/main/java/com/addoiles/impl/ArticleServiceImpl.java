package com.addoiles.impl;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Article;
import com.addoiles.exception.BusinessException;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.ArticleService;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>All rights Reserved, Designed By HQYG.</p>
 *
 * @author Yangrunkang
 * @Copyright Copyright(C) 2017.
 * @Company HQYG.
 * @CreateDate 9/24/2017 15:17
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private OilRedisService oilRedisService;

    @Override
    public List<Article> getList(QueryDto queryDto) {
        List<Article> articleList = new ArrayList<>(10);
        //根据添加获取文章ID集合
        List<String> articleIdList = articleMapper.getArticleIdList(queryDto);
        if (CollectionUtils.isEmpty(articleIdList)) {
            return articleList;
        }

        articleIdList.forEach(articleId -> {
            articleList.add(oilRedisService.getArticleByArticleId(articleId));
        });

        return articleList;
    }

    @OilLog
    @Override
    public Integer insert(Article article) {
        oilRedisService.addArticle(article);
        return articleMapper.insert(article);
    }

    @Override
    public Article getByBusinessId(String businessId) {
        return oilRedisService.getArticleByArticleId(businessId);
    }


    @OilLog
    @Override
    public Integer update(Article article) {
        Article redisArticle = oilRedisService.getArticleByArticleId(article.getArticleId());
        if(Objects.isNull(redisArticle)){
            throw new BusinessException(ErrorCode.ARTICLE_NOT_EXISTS);
        }

        redisArticle.setIsHide(article.getIsHide());
        redisArticle.setDeleteStatus(article.getDeleteStatus());
        redisArticle.setTitle(article.getTitle());
        redisArticle.setContent(article.getContent());
        redisArticle.setUpdateTime(TimeUtil.currentTime());

        oilRedisService.updateArticle(redisArticle);

        return articleMapper.update(article);
    }


    @OilLog
    @Override
    public Integer delete(String articleId) {
        oilRedisService.deleteArticleByArticleId(articleId);
        return articleMapper.delete(articleId);
    }

    @Override
    public List<Article> getSimpleList(QueryDto queryDto) {
        return articleMapper.getSimpleList(queryDto);
    }

    @Override
    public Integer getTotalCount(QueryDto queryDto) {
        return articleMapper.getTotalCount(queryDto);
    }
}
