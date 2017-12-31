package service;


import com.addoiles.BaseService;
import com.addoiles.entity.Comment;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface CommentService extends BaseService<Comment> {

    /**
     * 获取目标内容的评论
     *
     * @param targetId
     * @return
     */
    List<Comment> getCommentListByTargetId(String targetId);



}
