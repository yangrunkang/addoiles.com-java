package service;

import com.addoiles.BaseService;
import com.addoiles.dto.req.LatestReq;
import com.addoiles.entity.MicroContent;

import java.util.List;

/**
 * Description: 微内容接口
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/22 16:39
 */

public interface MicroContentService extends BaseService<MicroContent> {

    /**
     * 最近微内容
     * @param latestReq
     * @return
     */
    List<MicroContent> getLatest(LatestReq latestReq);

}
