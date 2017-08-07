package com.addoiles.service.impl;

import com.addoiles.dao.OilCommentMapper;
import com.addoiles.entity.OilComment;
import com.addoiles.service.OilCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:28
 */
@Service
public class OilCommentServiceImpl implements OilCommentService {

    @Autowired
    private OilCommentMapper oilCommentMapper;

    @Override
    public Integer insert(OilComment oilComment) {
        return oilCommentMapper.insert(oilComment);
    }

}
