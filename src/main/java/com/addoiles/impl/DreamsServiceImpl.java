package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.dao.DreamsMapper;
import com.addoiles.entity.Dreams;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.jca.cci.core.InteractionCallback;
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

    @Override
    public Integer addDream(Dreams dreams) {
        //默认值
        dreams.setDreamId(OilUtils.generateID());
        dreams.setUserId(OilUtils.generateID());
        dreams.setCreateTime(TimeUtil.currentTime());
        dreams.setLikes(0);
        dreams.setDeleteStatus(0);
        return dreamsMapper.insert(dreams);
    }
}
