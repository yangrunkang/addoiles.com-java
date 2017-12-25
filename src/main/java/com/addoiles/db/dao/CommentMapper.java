package com.addoiles.db.dao;

import com.addoiles.entity.Comment;
import org.apache.ibatis.annotations.Param;
import com.addoiles.BaseService;

import java.util.List;

public interface CommentMapper extends BaseService<Comment> {

    List<Comment> selectByTargetId(@Param("targetId") String targetId);
}