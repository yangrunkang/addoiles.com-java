package com.addoiles.dto;

import com.addoiles.entity.Comment;
import com.addoiles.entity.Question;

import java.util.List;

/**
 * 问题回答Dto
 * Created by bla on 10/4/2017.
 */
public class QuestionAnswerDto {

    private Question question;

    private List<Comment> answerList;


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Comment> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Comment> answerList) {
        this.answerList = answerList;
    }
}
