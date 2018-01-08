package com.addoiles.db.redis.dto;

import com.addoiles.entity.MicroContent;

import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/8 15:24
 */

public class MicroContentDto {

    private List<MicroContent> microContentList;

    public List<MicroContent> getMicroContentList() {
        return microContentList;
    }

    public void setMicroContentList(List<MicroContent> microContentList) {
        this.microContentList = microContentList;
    }
}
