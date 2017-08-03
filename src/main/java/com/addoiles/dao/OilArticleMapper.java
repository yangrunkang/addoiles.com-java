package com.addoiles.dao;

import com.addoiles.entity.OilArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OilArticleMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilArticle record);


    int insertSelective(OilArticle record);


    OilArticle selectByPrimaryKey(String id);

    List<OilArticle> selectsLatest(@Param("type")Integer type);


    /**
     * 根据类型查询文章
     * @param type  1-梦想 2-经历 3-最近难点 4-吐槽 5-新闻
     * @param limitSize 查询数量
     * @return
     */
    List<OilArticle> selectsByType(@Param("type") Integer type, @Param("limitSize") Integer limitSize);


    int updateByPrimaryKeySelective(OilArticle record);


    int updateByPrimaryKey(OilArticle record);
}