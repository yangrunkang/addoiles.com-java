package service;

import com.addoiles.BaseService;
import com.addoiles.dto.req.LatestReq;
import com.addoiles.entity.Suggest;

import java.util.List;

/**
 * Created by bla on 10/3/2017.
 */
public interface SuggestService extends BaseService<Suggest> {

    /**
     * 获取建议
     * @param latestReq
     * @return
     */
    List<Suggest> getLatest(LatestReq latestReq);
}
