package com.addoiles.db.cache;

import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.Article;
import com.addoiles.util.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 程序启动时缓存数据库所有文章
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/3 9:06
 */
@Component
public class OilCache {


    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private RedisService redisService;


    /**
     * 缓存所有文章
     */
    private void cacheAllArticles() {

        this.initRedis();

        this.cacheArticle();

    }

    /**
     * 初始化redis
     */
    private void initRedis(){
        redisService.deleteKeys(OilRedisConstant.OIL_WEBSITE + "*");
    }

    /**
     * 缓存文章
     */
    private void cacheArticle() {
        List<Article> allArticles = articleMapper.getAllArticles();
        if (CollectionUtils.isEmpty(allArticles)) {
            return;
        }
        allArticles.forEach(article ->
                redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article))
        );
    }
}
