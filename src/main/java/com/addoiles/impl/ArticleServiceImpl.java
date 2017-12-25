package com.addoiles.impl;

import com.addoiles.common.Page;
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
 * Created by bla on 9/24/2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getList(QueryDto queryDto) {
        return articleMapper.getList(queryDto);
    }

    @Override
    public List<Article> selectPithinessByType(Page page, Integer articleType) {
        return articleMapper.selectPithinessByType(page, articleType);
    }


    @OilLog
    @Override
    public Integer insert(Article article) {
        //articleType从前端传过来
        article.setArticleId(OilUtils.generateID());
        article.setDeleteStatus(0);
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
        Article tmp = new Article();
        tmp.setArticleId(article.getArticleId());
        tmp.setTitle(article.getTitle());
        tmp.setSubTitle(article.getSubTitle());
        tmp.setContent(article.getContent());
        tmp.setUpdateTime(TimeUtil.currentTime());
        return articleMapper.update(tmp);
    }


    @OilLog
    @Override
    public Integer delete(String articleId) {
        return articleMapper.delete(articleId);
    }

}
