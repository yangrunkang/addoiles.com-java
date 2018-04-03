package com.addoiles.impl;

import com.addoiles.ManagerService;
import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.QuestionMapper;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Question;
import org.springframework.stereotype.Service;
import service.QuestionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService,ManagerService<Question> {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getList(QueryDto queryDto) {
        return questionMapper.getList(queryDto);
    }

    @OilLog
    @Override
    public Integer insert(Question question) {
        return questionMapper.insert(question);
    }



    @OilLog
    @Override
    public Integer delete(String questionId) {
        return questionMapper.delete(questionId);
    }

    @Override
    public Integer update(Question question) {
        return null;
    }

    @Override
    public Question getByBusinessId(String businessId) {
        return null;
    }

    @Override
    public List<Question> getSimpleList(QueryDto queryDto) {
        return questionMapper.getSimpleList(queryDto);
    }

    @Override
    public Integer getTotalCount(QueryDto queryDto) {
        return null;
    }
}
