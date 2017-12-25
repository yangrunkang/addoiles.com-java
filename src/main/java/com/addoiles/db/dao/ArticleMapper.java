package com.addoiles.db.dao;

import com.addoiles.BaseService;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArticleMapper extends BaseService<Article> {


    /**
     * 查询简洁的文章
     * 只查询文章id,文章标题,副标题
     *
     */
    List<Article> selectPithinessByType(@Param("queryDto")QueryDto queryDto);



}