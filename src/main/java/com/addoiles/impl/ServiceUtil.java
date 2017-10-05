package com.addoiles.impl;

import com.addoiles.entity.Comment;
import com.addoiles.entity.Experience;
import com.addoiles.entity.User;

import java.util.List;

/**
 * Created by bla on 10/3/2017.
 */
public class ServiceUtil {

    public static void HandleCommentUserIdToUserName(List<Comment> commentList, List<User> userList){
        commentList.forEach(comment -> {
            userList.forEach(user -> {
                if (comment.getUserId().equals(user.getUserId())) {
                    comment.setUserName(user.getName());
                }//notice: none else
            });
        });
    }

    public static void HandleExperienceUserIdToUserName(List<Experience> experienceList, List<User> userList){
        experienceList.forEach(experience -> {
            userList.forEach(user -> {
                if (experience.getUserId().equals(user.getUserId())) {
                    experience.setUserName(user.getName());
                }
            });
        });
    }

}
