package com.addoiles.db.dao;

import com.addoiles.BaseService;
import com.addoiles.ManagerService;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper extends BaseService<Question>,ManagerService<Question> {

    /**
     * 获取所有问题
     * @return
     */
    List<Question> getAllQuestions();

    /**
     * 获取最新提问列表
     * @param queryDto
     * @return
     */
    List<Question> getLatestList(@Param("queryDto")QueryDto queryDto);

}