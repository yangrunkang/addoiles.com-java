package com.addoiles.db.dao;

import com.addoiles.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Comment record);


    Comment selectByPrimaryKey(Integer id);


    List<Comment> selectAll();

    List<Comment> selectByTargetId(@Param("targetId") String targetId);


    int updateByPrimaryKey(Comment record);
}