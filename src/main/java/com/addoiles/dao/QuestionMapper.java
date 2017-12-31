package com.addoiles.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);


    Question selectByPrimaryKey(Integer id);

    /**
     * 查找最新的问题
     * @param page
     * @return
     */
    List<Question> selectQuestionList(@Param("page") Page page);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}