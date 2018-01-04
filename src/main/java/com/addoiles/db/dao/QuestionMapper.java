package com.addoiles.db.dao;

import com.addoiles.BaseService;
import com.addoiles.ManagerService;
import com.addoiles.entity.Question;

import java.util.List;

public interface QuestionMapper extends BaseService<Question>,ManagerService<Question> {


    /**
     * 获取所有问题
     * @return
     */
    List<Question> getAllQuestions();

}