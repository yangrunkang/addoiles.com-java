package com.addoiles.dao;

import com.addoiles.entity.OilArticle;

public interface OilArticleMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilArticle record);


    int insertSelective(OilArticle record);


    OilArticle selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OilArticle record);


    int updateByPrimaryKey(OilArticle record);
}