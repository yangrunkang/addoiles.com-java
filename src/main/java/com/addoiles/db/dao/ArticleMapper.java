package com.addoiles.db.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Article;
import org.apache.ibatis.annotations.Param;
import com.addoiles.BaseService;

import java.util.List;


public interface ArticleMapper extends BaseService<Article> {


    /**
     * 查询简洁的文章
     * 只查询文章id,文章标题,副标题
     *
     * @param page        分页对象
     * @param articleType 文章类型 1-软件评测 2-技术沉淀
     * @return
     */
    List<Article> selectPithinessByType(@Param("page") Page page, @Param("articleType") Integer articleType);



}