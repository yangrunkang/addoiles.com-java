package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.db.dao.QuestionMapper;
import com.addoiles.entity.Question;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.QuestionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionList(Page page) {
        return questionMapper.selectQuestionList(page);
    }

    @Override
    public Integer addQuestion(Question question) {
        question.setQuestionId(OilUtils.generateID());
        question.setCreateTime(TimeUtil.currentTime());
        question.setDeleteStatus(0);
        return questionMapper.insert(question);
    }

    @Override
    public List<Question> getQuestionsByUserId(String userId) {
        return questionMapper.selectQuestionListByUserId(userId);
    }

    @Override
    public Integer deleteByQuestionId(String questionId) {
        return questionMapper.deleteByQuestionId(questionId);
    }
}
