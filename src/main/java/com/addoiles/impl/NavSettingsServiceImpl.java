package com.addoiles.impl;

import com.addoiles.db.dao.NavSettingsMapper;
import com.addoiles.entity.NavSettings;
import org.springframework.stereotype.Service;
import service.NavSettingsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 10/1/2017.
 */
@Service
public class NavSettingsServiceImpl implements NavSettingsService {

    @Resource
    private NavSettingsMapper navSettingsMapper;

    @Override
    public List<NavSettings> getNavs() {
        return navSettingsMapper.selectAll();
    }


}
