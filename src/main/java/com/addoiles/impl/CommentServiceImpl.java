package com.addoiles.impl;

import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.CommentMapper;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.Comment;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
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

    @OilLog
    @Override
    public Integer insert(Comment comment) {
        comment.setCommitId(OilUtils.generateID());
        comment.setDeleteStatus(0);
        comment.setCreateTime(TimeUtil.currentTime());
        return commentMapper.insert(comment);
    }

    @Override
    public Integer delete(String businessId) {
        return null;
    }

    @Override
    public Integer update(Comment comment) {
        return null;
    }

    @Override
    public Comment getByBusinessId(String businessId) {
        return null;
    }

    @Override
    public List<Comment> getList(QueryDto queryDto) {
        return null;
    }
}
