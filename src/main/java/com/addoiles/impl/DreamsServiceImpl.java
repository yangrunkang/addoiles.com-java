package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.DreamsMapper;
import com.addoiles.entity.Dreams;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.DreamsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class DreamsServiceImpl implements DreamsService {

    @Resource
    private DreamsMapper dreamsMapper;

    @Override
    public List<Dreams> getDreams(Page page) {
        return dreamsMapper.selectAll(page);
    }

    @OilLog
    @Override
    public Integer addDream(Dreams dreams) {
        //默认值
        dreams.setDreamId(OilUtils.generateID());
        dreams.setUserId(dreams.getUserId() == null ? "no user" : dreams.getUserId());
        dreams.setCreateTime(TimeUtil.currentTime());
        dreams.setLikes(0);
        dreams.setDeleteStatus(0);
        return dreamsMapper.insert(dreams);
    }

    @Override
    public List<Dreams> getDreamsByUserId(String userId) {
        return dreamsMapper.selectByUserId(userId);
    }

    @OilLog
    @Override
    public Integer deleteByDreamId(String dreamId) {
        return dreamsMapper.deleteByDreamId(dreamId);
    }
}
