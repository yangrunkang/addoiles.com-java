package com.addoiles.sync;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.db.dao.*;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.dto.MicroContentDto;
import com.addoiles.db.redis.dto.NavDto;
import com.addoiles.db.redis.dto.RecommendDto;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.sync.*;
import com.addoiles.entity.*;
import com.addoiles.util.JsonUtils;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 缓存监听器
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/20 14:36
 */
@OilEventListener
@Component
public class CacheListener {

    private static final Logger logger = LoggerFactory.getLogger(CacheListener.class);

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private NavSettingsMapper navSettingsMapper;

    @Resource
    private RecommendMapper recommendMapper;

    @Resource
    private MicroContentMapper microContentMapper;

    @Subscribe
    public void deadEvent(DeadEvent deadEvent){
        logger.error("deadEvent:{}", JsonUtils.toJson(deadEvent));
    }

    /**
     * 缓存文章
     */
    @Subscribe
    void cacheArticle(CacheArticleEvent cacheArticleEvent) {
        List<Article> allArticles = articleMapper.getAllArticles();
        if (CollectionUtils.isEmpty(allArticles)) {
            return;
        }
        allArticles.forEach(article -> {
            //缓存完整内容
            redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article));
        });
        logger.info("cacheArticle done");
    }

    /**
     * 缓存所有问题
     */
    @Subscribe
    void cacheQuestion(CacheQuestionEvent cacheQuestionEvent) {
        List<Question> allQuestions = questionMapper.getAllQuestions();
        if (CollectionUtils.isEmpty(allQuestions)) {
            return;
        }
        allQuestions.forEach(question ->
                redisService.set(OilRedisConstant.OIL_WEBSITE + question.getQuestionId(), JsonUtils.toJson(question))
        );
        logger.info("cacheQuestion done");
    }

    /**
     * 缓存导航栏
     */
    @Subscribe
    public List<NavSettings> cacheNavList(CacheNavListEvent cacheNavListEvent){
        List<NavSettings> navSettingsList = navSettingsMapper.getList(null);
        NavDto navDto = new NavDto();
        navDto.setNavSettings(navSettingsList);
        redisService.set(OilRedisConstant.NAV_LIST, JsonUtils.toJson(navDto));
        logger.info("cacheNavList done");
        return navSettingsList;
    }

    /**
     * 缓存首页图片
     */
    @Subscribe
    public List<Recommend> cacheFirstPageImage(CachePageImageEvent cachePageImageEvent){
        List<Recommend> recommendList = recommendMapper.getList(null);
        if(!CollectionUtils.isEmpty(recommendList)){
            RecommendDto recommendDto = new RecommendDto();
            recommendDto.setRecommendList(recommendList);
            redisService.set(OilRedisConstant.FIRST_PAGE_IMAGE,JsonUtils.toJson(recommendDto));
        }
        logger.info("cacheFirstPageImage done");
        return recommendList;
    }

    /**
     * 缓存梦想
     */
    @Subscribe
    public List<MicroContent> cacheDreams(CacheDreamEvent cacheDreamEvent){
        QueryDto queryDto = new QueryDto();
        queryDto.setMicroType(1);
        List<MicroContent> dreamList = microContentMapper.getList(queryDto);
        if(!CollectionUtils.isEmpty(dreamList)){
            MicroContentDto microContentDto = new MicroContentDto();
            microContentDto.setMicroContentList(dreamList);
            redisService.set(OilRedisConstant.DREAMS,JsonUtils.toJson(microContentDto));
            logger.info("cacheDreams done");
        }
        return dreamList;
    }
}
