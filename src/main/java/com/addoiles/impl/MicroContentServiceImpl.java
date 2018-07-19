package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.common.annotations.OilLog;
import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.dao.MicroContentMapper;
import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.db.eventbus.event.ReCacheDreamsEvent;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.req.LatestReq;
import com.addoiles.entity.Article;
import com.addoiles.entity.MicroContent;
import com.addoiles.entity.User;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.MicroContentService;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<MicroContent> microContentList = microContentMapper.getList(queryDto);
        if(!CollectionUtils.isEmpty(microContentList)){
            List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
            ServiceUtil.HandleMicroContentUserIdToUserName(microContentList, usersOfIdNameList);
        }

        return microContentList;
    }

    @Override
    public List<MicroContent> getLatest(LatestReq latestReq) {
        //分页
        Page page = new Page();
        page.setPageNo(1);
        page.setPageSize(2);
        //查询对象
        QueryDto queryDto = new QueryDto();
        queryDto.setPage(page);
        queryDto.setUserId(latestReq.getUserId());
        //获取梦想
        queryDto.setMicroType(DBFieldEnum.MicroContentType.DREAMS.getValue());
        List<MicroContent> dreamsList = microContentMapper.getLatestList(queryDto);
        //获取动弹
        queryDto.setMicroType(DBFieldEnum.MicroContentType.HOTS.getValue());
        List<MicroContent> hotsList = microContentMapper.getLatestList(queryDto);

        //集合
        List<MicroContent> microContentList = new ArrayList<>();
        microContentList.addAll(dreamsList);
        microContentList.addAll(hotsList);
        return microContentList;
    }
}
