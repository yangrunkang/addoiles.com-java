package service;

import com.addoiles.common.Page;
import com.addoiles.entity.Question;

import java.util.List;

/**
 * Created by bla on 10/4/2017.
 */
public interface QuestionService {

    List<Question> getQuestionList(Page page);

    Integer addQuestion(Question question);

    /***
     * 获取用户问题
     * @param userId
     * @return
     */
    List<Question> getQuestionsByUserId(String userId);

}
