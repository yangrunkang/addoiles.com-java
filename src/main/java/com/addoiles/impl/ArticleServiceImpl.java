package com.addoiles.impl;

import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.Article;
import com.addoiles.util.JsonUtils;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import service.ArticleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private RedisService redisService;

    @Override
    public List<Article> getList(QueryDto queryDto) {
        List<Article> articleList = new ArrayList<>(10);

        List<String> articleIdList = articleMapper.getArticleIdList(queryDto);
        if (CollectionUtils.isEmpty(articleIdList)) {
            return articleList;
        }

        articleIdList.forEach(articleId -> {
            String articleJson = redisService.get(OilRedisConstant.OIL_WEBSITE + articleId);
            if (StringUtils.isEmpty(articleJson)) {
                Article byBusinessId = articleMapper.getByBusinessId(articleId);
                articleJson = JsonUtils.toJson(byBusinessId);
            }

            articleList.add(JsonUtils.fromJson(articleJson, Article.class));
        });

        return articleList;
    }

    @OilLog
    @Override
    public Integer insert(Article article) {
        article.setArticleId(OilUtils.generateID());
        article.setRates(0);
        article.setRateCount(0);
        article.setCreateTime(TimeUtil.currentTime());

        redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article));

        return articleMapper.insert(article);
    }

    @Override
    public Article getByBusinessId(String businessId) {

        String articleJson = redisService.get(OilRedisConstant.OIL_WEBSITE + businessId);

        if (StringUtils.isEmpty(articleJson)) {
            Article byBusinessId = articleMapper.getByBusinessId(businessId);
            articleJson = JsonUtils.toJson(byBusinessId);
        }

        return JsonUtils.fromJson(articleJson, Article.class);
    }


    @OilLog
    @Override
    public Integer update(Article article) {
        article.setUpdateTime(TimeUtil.currentTime());

        redisService.delete(OilRedisConstant.OIL_WEBSITE + article.getArticleId());
        redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article));

        return articleMapper.update(article);
    }


    @OilLog
    @Override
    public Integer delete(String articleId) {
        redisService.delete(OilRedisConstant.OIL_WEBSITE + articleId);
        return articleMapper.delete(articleId);
    }

    @Override
    public List<Article> getSimpleList(QueryDto queryDto) {
        return articleMapper.getSimpleList(queryDto);
    }
}
