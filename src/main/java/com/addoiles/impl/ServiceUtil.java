package com.addoiles.impl;

import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;
import com.addoiles.entity.MicroContent;
import com.addoiles.entity.User;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by bla on 10/3/2017.
 */
public class ServiceUtil {

    /**
     * 评论信息 UserId 转 UserName
     * @param commentList
     * @param userList
     */
    public static void HandleCommentUserIdToUserName(List<Comment> commentList, List<User> userList) {
        commentList.forEach(comment -> {
            userList.forEach(user -> {
                if (comment.getUserId().equals(user.getUserId())) {
                    comment.setUserName(user.getName());
                }//notice: none else
            });
        });
    }

    /**
     * 文章信息 UserId 转 UserName
     * @param articleList
     * @param userList
     */
    public static void HandleArticleUserIdToUserName(List<Article> articleList, List<User> userList) {

        if (CollectionUtils.isEmpty(articleList)) {
            return;
        }

        articleList.forEach(article -> {
            userList.forEach(user -> {
                if (article.getUserId().equals(user.getUserId())) {
                    article.setUserName(user.getName());
                }
            });
        });
    }

    /**
     * 微内容 UserId 转 UserName
     * @param articleList
     * @param userList
     */
    public static void HandleMicroContentUserIdToUserName(List<MicroContent> articleList, List<User> userList) {

        if (CollectionUtils.isEmpty(articleList)) {
            return;
        }

        articleList.forEach(article -> {
            userList.forEach(user -> {
                if (article.getUserId().equals(user.getUserId())) {
                    article.setUserName(user.getName());
                }
            });
        });
    }

}
