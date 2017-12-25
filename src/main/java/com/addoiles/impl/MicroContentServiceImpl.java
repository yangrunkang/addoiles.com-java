package com.addoiles.impl;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.dao.MicroContentMapper;
import com.addoiles.dto.db.QueryMicroContentDto;
import com.addoiles.entity.MicroContent;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import service.MicroContentService;

import javax.annotation.Resource;
import java.util.List;

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
    public int add(MicroContent microContent) {
        microContent.setMicroId(OilUtils.generateID());
        microContent.setDeleteStatus(DBFieldEnum.MicroContentDeleteStatus.NORMAL.getValue());
        microContent.setCreateTime(TimeUtil.currentTime());
        return microContentMapper.insert(microContent);
    }

    @Override
    public int delete(MicroContent microContent) {
        return 0;
    }

    @Override
    public int update(MicroContent microContent) {
        return 0;
    }

    @Override
    public MicroContent get(String id) {
        return null;
    }

    @Override
    public List<MicroContent> getList(Object queryMicroContentDto) {
        return microContentMapper.queryByDto((QueryMicroContentDto)queryMicroContentDto);
    }


}
