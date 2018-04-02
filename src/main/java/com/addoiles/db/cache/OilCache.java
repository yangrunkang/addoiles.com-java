package com.addoiles.db.cache;

import com.addoiles.db.dao.*;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.dto.MicroContentDto;
import com.addoiles.db.redis.dto.NavDto;
import com.addoiles.db.redis.dto.RecommendDto;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.*;
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

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private NavSettingsMapper navSettingsMapper;

    @Resource
    private RecommendMapper recommendMapper;

    @Resource
    private MicroContentMapper microContentMapper;


    /**
     * 缓存所有文章
     */
    private void cacheAllArticles() {

        //删除redis key
        this.delRedisKeys();

        //缓存文章
        this.cacheArticle();

        //缓存问题
        this.cacheQuestion();

        //缓存导航栏
        this.cacheNavList();

        //缓存首页图片
        this.cacheFirstPageImage();

        //缓存梦想
        this.cacheDreams();

    }

    /**
     * 清楚redis所有key
     */
    private void delRedisKeys() {
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
        allArticles.forEach(article -> {
            //缓存完整内容
            redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article));
        });
    }

    /**
     * 缓存所有问题
     */
    private void cacheQuestion() {
        List<Question> allQuestions = questionMapper.getAllQuestions();
        if (CollectionUtils.isEmpty(allQuestions)) {
            return;
        }
        allQuestions.forEach(question ->
                redisService.set(OilRedisConstant.OIL_WEBSITE + question.getQuestionId(), JsonUtils.toJson(question))
        );
    }

    /**
     * 缓存导航栏
     */
    public List<NavSettings> cacheNavList(){
        List<NavSettings> navSettingsList = navSettingsMapper.getList(null);
        NavDto navDto = new NavDto();
        navDto.setNavSettings(navSettingsList);
        redisService.set(OilRedisConstant.NAV_LIST, JsonUtils.toJson(navDto));
        return navSettingsList;
    }

    /**
     * 缓存首页图片
     */
    public List<Recommend> cacheFirstPageImage(){
        List<Recommend> recommendList = recommendMapper.getList(null);
        if(!CollectionUtils.isEmpty(recommendList)){
            RecommendDto recommendDto = new RecommendDto();
            recommendDto.setRecommendList(recommendList);
            redisService.set(OilRedisConstant.FIRST_PAGE_IMAGE,JsonUtils.toJson(recommendDto));
        }
        return recommendList;
    }

    /**
     * 缓存梦想
     */
    public List<MicroContent> cacheDreams(){
        QueryDto queryDto = new QueryDto();
        queryDto.setMicroType(1);
        List<MicroContent> dreamList = microContentMapper.getList(queryDto);
        if(!CollectionUtils.isEmpty(dreamList)){
            MicroContentDto microContentDto = new MicroContentDto();
            microContentDto.setMicroContentList(dreamList);
            redisService.set(OilRedisConstant.DREAMS,JsonUtils.toJson(microContentDto));
        }
        return dreamList;
    }
}
