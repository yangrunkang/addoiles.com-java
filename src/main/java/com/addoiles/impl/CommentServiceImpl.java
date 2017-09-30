package com.addoiles.impl;

import com.addoiles.dao.CommentMapper;
import com.addoiles.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentListByTargetId(String targetId) {
        return commentMapper.selectByTargetId(targetId);
    }

}
