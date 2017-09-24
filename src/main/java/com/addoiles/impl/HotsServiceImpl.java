package com.addoiles.impl;

import com.addoiles.dao.HotsMapper;
import com.addoiles.entity.Hots;
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
    public List<Hots> getLatestHots() {
        return hotsMapper.selectAll();
    }

    @Override
    public List<Hots> getHotestHots() {
        return null;
    }
}
