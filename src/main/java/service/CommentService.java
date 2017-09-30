package service;


import com.addoiles.entity.Comment;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface CommentService {

    List<Comment> getCommentListByTargetId(String targetId);

}
