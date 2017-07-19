package com.addoiles.dao;

import com.addoiles.entity.OilComment;

public interface OilCommentMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilComment record);


    int insertSelective(OilComment record);


    OilComment selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OilComment record);


    int updateByPrimaryKey(OilComment record);
}