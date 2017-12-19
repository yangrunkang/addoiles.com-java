package com.addoiles.dto.view;

import com.addoiles.entity.Comment;
import com.addoiles.entity.Experience;

import java.util.List;

/**
 * 经历分享页DTO
 * Created by bla on 10/1/2017.
 */
public class ExperienceDto {

    /**
     * 经历
     */
    private Experience experience;

    /**
     * 评论列表
     */
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}
