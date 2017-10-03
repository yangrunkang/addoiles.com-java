package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.dao.HotsMapper;
import com.addoiles.entity.Hots;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.HotsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class HotsServiceImpl implements HotsService{

    @Resource
    private HotsMapper hotsMapper;

    @Override
    public List<Hots> getLatestHots(Page page) {
        return hotsMapper.selectAll(page);
    }

    @Override
    public Integer addHots(Hots hots) {
        //用户id可为空
        hots.setHotId(OilUtils.generateID());
        hots.setDeleteStatus(0);
        hots.setCreateTime(TimeUtil.currentTime());
        return hotsMapper.insert(hots);
    }
}
