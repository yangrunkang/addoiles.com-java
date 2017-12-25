package com.addoiles.impl;

import com.addoiles.common.annotations.OilLog;
import com.addoiles.db.dao.SuggestMapper;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.Suggest;
import org.springframework.stereotype.Service;
import service.SuggestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class SuggestServiceImpl implements SuggestService {

    @Resource
    private SuggestMapper suggestMapper;

    @OilLog
    @Override
    public Integer insert(Suggest suggest) {
        suggestMapper.insert(suggest);
    }

    @Override
    public Integer delete(String businessId) {
        return null;
    }

    @Override
    public Integer update(Suggest suggest) {
        return null;
    }

    @Override
    public Suggest getByBusinessId(String businessId) {
        return null;
    }

    @Override
    public List<Suggest> getList(QueryDto queryDto) {
        return null;
    }


}
