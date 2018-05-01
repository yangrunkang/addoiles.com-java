package com.addoiles.db.dao;

import com.addoiles.BaseService;
import com.addoiles.ManagerService;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArticleMapper extends BaseService<Article>,ManagerService<Article> {

    /**
     * 获取文章列表
     * @apiNote 网站 (不和任何状态相关，保证页面显示10条数据)
     */
    List<Article> getArticleList(@Param("queryDto")QueryDto queryDto);

    /**
     * 获取所有文章
     * @apiNote 缓存至redis
     * @return
     */
    List<Article> getAllArticles();

    /**
     * 根据条件获取文章ID集合
     * @param queryDto
     * @return
     */
    List<String> getArticleIdList(@Param("queryDto")QueryDto queryDto);
}