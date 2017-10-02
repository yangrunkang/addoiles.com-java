package com.addoiles.impl;

import com.addoiles.entity.Comment;
import com.addoiles.entity.User;

import java.util.List;

/**
 * Created by bla on 10/3/2017.
 */
public class ServiceUtil {

    public static void HandleUserIdToUserName(List<Comment> commentList,List<User> userList){
        commentList.forEach(comment -> {
            userList.forEach(user -> {
                if (comment.getUserId().equals(user.getUserId())) {
                    comment.setUserName(user.getName());
                } else {
                    comment.setUserName("Oil客");
                }
            });
        });
    }

}
