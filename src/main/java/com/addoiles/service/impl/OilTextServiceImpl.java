package com.addoiles.service.impl;

import com.addoiles.dao.OilTextMapper;
import com.addoiles.entity.OilText;
import com.addoiles.service.OilTextService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:28
 */
@Service
public class OilTextServiceImpl implements OilTextService {

    @Autowired
    private OilTextMapper oilTextMapper;


    @Override
    public OilText selectByArticleId(String articleId) {
        return oilTextMapper.selectByArticleId(articleId);
    }

    @Override
    public Integer insert(OilText oilText) {
        return oilTextMapper.insert(oilText);
    }
}
