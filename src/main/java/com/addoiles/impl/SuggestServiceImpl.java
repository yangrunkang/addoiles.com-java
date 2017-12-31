package com.addoiles.impl;

import com.addoiles.dao.SuggestMapper;
import com.addoiles.entity.Suggest;
import org.springframework.stereotype.Service;
import service.SuggestService;

import javax.annotation.Resource;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class SuggestServiceImpl implements SuggestService{

    @Resource
    private SuggestMapper suggestMapper;

    @Override
    public void suggest(Suggest suggest) {
        suggestMapper.insert(suggest);
    }
}
