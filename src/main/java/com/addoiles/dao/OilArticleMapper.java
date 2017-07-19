package com.addoiles.dao;

import com.addoiles.entity.OilArticle;

import java.util.List;

public interface OilArticleMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilArticle record);


    int insertSelective(OilArticle record);


    OilArticle selectByPrimaryKey(String id);

    List<OilArticle> selectsLatest();


    int updateByPrimaryKeySelective(OilArticle record);


    int updateByPrimaryKey(OilArticle record);
}