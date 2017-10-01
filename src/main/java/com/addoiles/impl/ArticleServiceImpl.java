package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.dao.ArticleMapper;
import com.addoiles.entity.Article;
import org.springframework.stereotype.Service;
import service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getITTechArticleList(Page page) {
        return articleMapper.selectByArticleType(page,2);
    }

    @Override
    public List<Article> selectPithinessByType(Page page, Integer articleType) {
        return articleMapper.selectPithinessByType(page,articleType);
    }

    @Override
    public List<Article> getSoftwareTalkArticleList(Page page) {
        return articleMapper.selectByArticleType(page,1);
    }

    @Override
    public Article getArticleByParams(String articleId, Integer articleType) {
        return articleMapper.getArticleByParams(articleId,articleType);
    }

}
