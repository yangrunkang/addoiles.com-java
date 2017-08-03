package com.addoiles.service.impl;

import com.addoiles.dao.OilArticleMapper;
import com.addoiles.entity.OilArticle;
import com.addoiles.service.OilArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:28
 */
@Service
public class OilTextServiceImpl implements OilArticleService {

    @Autowired
    private OilArticleMapper oilArticleMapper;

    @Override
    public List<OilArticle> selectsLatest(Integer type) {
        return oilArticleMapper.selectsLatest(type);
    }

    @Override
    public List<OilArticle> selectsByType(Integer type, Integer limitSize) {
        return oilArticleMapper.selectsByType(type,limitSize);
    }

    @Override
    public Integer insert(OilArticle oilArticle) {
        return oilArticleMapper.insert(oilArticle);
    }
}
