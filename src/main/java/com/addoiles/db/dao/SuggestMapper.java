package com.addoiles.db.dao;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Suggest;
import com.addoiles.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SuggestMapper extends BaseService<Suggest> {

    /**
     * 建议
     * @param queryDto
     * @return
     */
    List<Suggest> getLatest(@Param("queryDto")QueryDto queryDto);

}