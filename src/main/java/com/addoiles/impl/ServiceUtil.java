package com.addoiles.impl;

import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;
import com.addoiles.entity.User;

import java.util.List;

/**
 * Created by bla on 10/3/2017.
 */
public class ServiceUtil {

    public static void HandleCommentUserIdToUserName(List<Comment> commentList, List<User> userList) {
        commentList.forEach(comment -> {
            userList.forEach(user -> {
                if (comment.getUserId().equals(user.getUserId())) {
                    comment.setUserName(user.getName());
                }//notice: none else
            });
        });
    }

    public static void HandleExperienceUserIdToUserName(List<Article> articleList, List<User> userList) {
        articleList.forEach(article -> {
            userList.forEach(user -> {
                if (article.getUserId().equals(user.getUserId())) {
                    article.setUserName(user.getName());
                }
            });
        });
    }

}
