package com.addoiles.db.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArticleMapper {

    int deleteByArticleId(String articleId);


    int insert(Article record);

    Article selectByArticleId(String articleId);

    /**
     * 根据文章类型获取
     *
     * @param page        分页对象
     * @param articleType 文章类型 0-经历分享 1-软件评测 2-技术沉淀
     * @return
     */
    List<Article> selectByArticleType(@Param("page") Page page, @Param("articleType") Integer articleType);


    List<Article> selectByArticleByUserId(@Param("userId") String userId, @Param("articleType") String articleType);

    /**
     * 查询简洁的文章
     * 只查询文章id,文章标题,副标题
     *
     * @param page        分页对象
     * @param articleType 文章类型 1-软件评测 2-技术沉淀
     * @return
     */
    List<Article> selectPithinessByType(@Param("page") Page page, @Param("articleType") Integer articleType);

    /**
     * 根据文章id和类型获取文章
     *
     * @param articleId   文章id
     * @param articleType 文章类型 1-软件评测 2-技术沉淀
     * @return
     */
    Article getArticleByParams(@Param("articleId") String articleId, @Param("articleType") Integer articleType);


    int updateByArticleId(Article record);


    int updateSelectiveByArticleId(Article record);
}