package com.addoiles.service.impl;

import com.addoiles.dao.OilArticleMapper;
import com.addoiles.dao.OilShareMapper;
import com.addoiles.entity.OilShare;
import com.addoiles.service.OilShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:28
 */
@Service
public class OilShareServiceImpl implements OilShareService {

    @Autowired
    private OilShareMapper oilShareMapper;

    @Override
    public List<OilShare> selectHotShare() {
        return oilShareMapper.selectHotShare();
    }

}
