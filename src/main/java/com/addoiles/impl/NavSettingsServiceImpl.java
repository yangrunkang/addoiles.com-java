package com.addoiles.impl;

import com.addoiles.db.dao.NavSettingsMapper;
import com.addoiles.dto.query.QueryDto;
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
        return navSettingsMapper.getList(null);
    }

    @Override
    public Integer insert(NavSettings navSettings) {
        return null;
    }

    @Override
    public Integer delete(String businessId) {
        return null;
    }

    @Override
    public Integer update(NavSettings navSettings) {
        return null;
    }

    @Override
    public NavSettings getByBusinessId(String businessId) {
        return null;
    }

    @Override
    public List<NavSettings> getList(QueryDto queryDto) {
        return null;
    }
}
