package com.addoiles.impl;

import com.addoiles.db.dao.MicroContentMapper;
import com.addoiles.entity.MicroContent;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import service.MicroContentService;

import javax.annotation.Resource;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/23 8:39
 */

public class MicroContentServiceImpl implements MicroContentService {

    @Resource
    private MicroContentMapper microContentMapper;

    @Override
    public int addMicroContent(MicroContent microContent) {

        microContent.setMicroId(OilUtils.generateID());

        microContent.setCreateTime(TimeUtil.currentTime());
        return microContentMapper.insert(microContent);
    }
}
