package com.addoiles.impl;

import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.db.dao.UserMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.dto.MicroContentDto;
import com.addoiles.db.redis.dto.NavDto;
import com.addoiles.db.redis.dto.RecommendDto;
import com.addoiles.db.redis.dto.UserIDNamesDto;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.*;
import com.addoiles.sync.CacheListener;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 16:55
 */
@Service
public class OilRedisServiceImpl implements OilRedisService {

    private static Logger logger = LoggerFactory.getLogger(OilRedisService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private CacheListener cacheListener;


    @Override
    public List<User> getUsersIdsNames(Boolean reload) {


        String userIdNamesJson = redisService.get(OilRedisConstant.USERS_ID_NAME_LIST);

        // userIdNamesJson 为空 或者 reload 为 true
        if (StringUtils.isEmpty(userIdNamesJson) || reload) {
            //删除
            redisService.delete(OilRedisConstant.USERS_ID_NAME_LIST);
            //重新查库
            UserIDNamesDto userIDNamesDto = new UserIDNamesDto();
            userIDNamesDto.setUserIdNameList(userMapper.getUsersOfIdNameList());
            redisService.set(OilRedisConstant.USERS_ID_NAME_LIST, JsonUtils.toJson(userIDNamesDto));
            //重新Get
            userIdNamesJson = redisService.get(OilRedisConstant.USERS_ID_NAME_LIST);
        }

        logger.info("redis key:{},value{}", OilRedisConstant.USERS_ID_NAME_LIST, userIdNamesJson);

        UserIDNamesDto userIDNamesDto = JsonUtils.fromJson(userIdNamesJson, UserIDNamesDto.class);

        if (Objects.isNull(userIDNamesDto)) {
            return new ArrayList<>();
        }

        List<User> userIdNames = userIDNamesDto.getUserIdNameList();

        if (CollectionUtils.isEmpty(userIdNames)) {
            userIdNames = new ArrayList<>();
        }

        return userIdNames;
    }

    @Override
    public void cacheUserVerifyCode(String email, String code) {
        redisService.setTTL(email, code, 60);
        logger.info("already cache user verify code,email:{},code:{}", email, code);
    }

    @Override
    public String getVerifyCodeByEmail(String email) {
        return redisService.get(email);
    }

    @Override
    public List<NavSettings> getNavList() {
        List<NavSettings> navSettingsList;
        NavDto navDto = JsonUtils.fromJson(redisService.get(OilRedisConstant.NAV_LIST), NavDto.class);
        if (Objects.isNull(navDto)) {
            redisService.delete(OilRedisConstant.NAV_LIST);
            return cacheListener.cacheNavList(null);
        }
        navSettingsList = navDto.getNavSettings();

        return navSettingsList;
    }


    @Override
    public Article getArticleByArticleId(String articleId) {
        Article article = JsonUtils.fromJson(redisService.get(OilRedisConstant.OIL_WEBSITE + articleId), Article.class);
        if (Objects.isNull(article)) {
            article = articleMapper.getByBusinessId(articleId);
            if(Objects.nonNull(article)){
                this.addArticle(article);
            }
        }
        return article;
    }

    @Override
    public void deleteArticleByArticleId(String articleId) {
        redisService.delete(OilRedisConstant.OIL_WEBSITE + articleId);
    }

    @Override
    public void deleteArticleByMicroContentId(String microContentId) {
        redisService.delete(OilRedisConstant.OIL_WEBSITE + microContentId);
    }

    @Override
    public void addArticle(Article article) {
        redisService.set(OilRedisConstant.OIL_WEBSITE + article.getArticleId(), JsonUtils.toJson(article));
    }

    @Override
    public void updateArticle(Article article) {
        this.deleteArticleByArticleId(article.getArticleId());
        this.addArticle(article);
    }

    @Override
    public List<Recommend> getRecommend() {

        String recommendJson = redisService.get(OilRedisConstant.FIRST_PAGE_IMAGE);
        if (StringUtils.isEmpty(recommendJson)) {
            redisService.delete(OilRedisConstant.FIRST_PAGE_IMAGE);
            return cacheListener.cacheFirstPageImage(null);
        }

        RecommendDto firstPageImageDto = JsonUtils.fromJson(recommendJson, RecommendDto.class);
        if (firstPageImageDto == null) {
            return new ArrayList<>();
        }

        return firstPageImageDto.getRecommendList();
    }

    @Override
    public List<MicroContent> getAllDreams() {

        String dreamListJson = redisService.get(OilRedisConstant.DREAMS);
        if (StringUtils.isEmpty(dreamListJson)) {
            redisService.delete(OilRedisConstant.DREAMS);
            return cacheListener.cacheDreams(null);
        }

        MicroContentDto microContentDto = JsonUtils.fromJson(dreamListJson, MicroContentDto.class);
        if (Objects.isNull(microContentDto)) {
            return new ArrayList<>();
        }
        return microContentDto.getMicroContentList();
    }

    @Override
    public void setUserTokenId(String userId, String tokenId) {
        if (!StringUtils.isEmpty(getUserTokenId(userId))) {
            deleteUserTokenId(getUserTokenIdKey(userId));
        }
        redisService.set(getUserTokenIdKey(userId), tokenId);
    }

    @Override
    public String getUserTokenId(String userId) {
        String tokenId = redisService.get(getUserTokenIdKey(userId));

        if(Objects.isNull(tokenId)){
            return null;
        }

        return tokenId;
    }

    @Override
    public void deleteUserTokenId(String userId) {
        redisService.delete(getUserTokenIdKey(userId));
    }

    /**
     * 获取用户tokenId key
     *
     * @param userId
     * @return
     */
    private String getUserTokenIdKey(String userId) {
        return "tokenId" + userId;
    }
}
