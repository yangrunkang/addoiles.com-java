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
public class OilArticleServiceImpl implements OilArticleService {

    @Autowired
    private OilArticleMapper oilArticleMapper;

    @Override
    public List<OilArticle> selectsLatest() {
        return oilArticleMapper.selectsLatest();
    }
}
