package com.addoiles.db.cache;

import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.db.dao.NavSettingsMapper;
import com.addoiles.db.dao.QuestionMapper;
import com.addoiles.db.dao.RecommendMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.dto.NavDto;
import com.addoiles.db.redis.dto.RecommendDto;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.Article;
import com.addoiles.entity.NavSettings;
import com.addoiles.entity.Question;
import com.addoiles.entity.Recommend;
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
    private void cacheNavList(){
        List<NavSettings> list = navSettingsMapper.getList(null);
        NavDto navDto = new NavDto();
        navDto.setNavSettings(list);
        redisService.set(OilRedisConstant.NAV_LIST, JsonUtils.toJson(navDto));
    }

    /**
     * 缓存首页图片
     */
    public void cacheFirstPageImage(){
        List<Recommend> list = recommendMapper.getList(null);
        if(!CollectionUtils.isEmpty(list)){
            RecommendDto recommendDto = new RecommendDto();
            recommendDto.setRecommendList(list);
            redisService.set(OilRedisConstant.FIRST_PAGE_IMAGE,JsonUtils.toJson(recommendDto));
        }
    }
}
