package com.addoiles.db.dao;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.MicroContent;
import com.addoiles.BaseService;
import org.apache.ibatis.annotations.Param;
import redis.clients.jedis.BinaryClient;

import java.util.List;

/**
 * 微内容Mapper
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/22 16:39
 */
public interface MicroContentMapper extends BaseService<MicroContent> {

    /**
     * 获取最近微内容列表
     * @param queryDto
     * @return
     */
    List<MicroContent> getLatestList(@Param("queryDto")QueryDto queryDto);

}