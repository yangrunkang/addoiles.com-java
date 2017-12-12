package service;


import com.addoiles.entity.Comment;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface CommentService {

    /**
     * 获取目标内容的评论
     *
     * @param targetId
     * @return
     */
    List<Comment> getCommentListByTargetId(String targetId);

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

}
