package com.addoiles.impl;

import com.addoiles.dao.CommentMapper;
import com.addoiles.entity.Comment;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
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

    @Override
    public Integer addComment(Comment comment) {
        comment.setCommitId(OilUtils.generateID());
        comment.setDeleteStatus(0);
        comment.setCreateTime(TimeUtil.currentTime());
        return commentMapper.insert(comment);
    }

}
