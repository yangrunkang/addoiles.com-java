package com.addoiles.dao;

import com.addoiles.entity.OilComment;

import java.util.List;

public interface OilCommentMapper {

    int deleteByPrimaryKey(String commentId);

    int insert(OilComment record);

    int insertSelective(OilComment record);

    OilComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OilComment record);

    int updateByPrimaryKey(OilComment record);

    List<OilComment> findExperenceComments(String articleId);
}