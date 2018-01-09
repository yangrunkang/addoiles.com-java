package com.addoiles.impl;

import com.addoiles.common.annotations.OilLog;
import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.dao.MicroContentMapper;
import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.db.eventbus.event.ReCacheDreamsEvent;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.MicroContent;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.MicroContentService;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/23 8:39
 */
@Service
public class MicroContentServiceImpl implements MicroContentService {

    @Resource
    private MicroContentMapper microContentMapper;

    @Resource
    private OilRedisService oilRedisService;

    @OilLog
    @Override
    public Integer insert(MicroContent microContent) {
        microContent.setMicroId(OilUtils.generateID());
        microContent.setLikes(0);
        microContent.setDeleteStatus(DBFieldEnum.MicroContentDeleteStatus.NORMAL.getValue());
        microContent.setCreateTime(TimeUtil.currentTime());

        int insert = microContentMapper.insert(microContent);

        if(insert > 0 && microContent.getMicroType() - DBFieldEnum.MicroContentType.DREAMS.getValue() == 0){
            OilEventBusHandle.getInstance().postEvent(new ReCacheDreamsEvent());
        }

        return insert;
    }

    @Override
    public Integer delete(String businessId) {

        oilRedisService.deleteArticleByMicroContentId(businessId);
        return microContentMapper.delete(businessId);
    }

    @Override
    public Integer update(MicroContent microContent) {
        return microContentMapper.update(microContent);
    }

    @Override
    public MicroContent getByBusinessId(String id) {
        return null;
    }

    @Override
    public List<MicroContent> getList(QueryDto queryDto) {
        return microContentMapper.getList(queryDto);
    }


}
