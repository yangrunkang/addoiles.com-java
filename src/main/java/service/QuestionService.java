package service;

import com.addoiles.BaseService;
import com.addoiles.ManagerService;
import com.addoiles.dto.req.LatestReq;
import com.addoiles.entity.Question;

import java.util.List;

/**
 * Created by bla on 10/4/2017.
 */
public interface QuestionService extends BaseService<Question>,ManagerService<Question> {

    /**
     * 最近提出的问题
     * @param latestReq
     * @return
     */
    List<Question> getLatest(LatestReq latestReq);



}
