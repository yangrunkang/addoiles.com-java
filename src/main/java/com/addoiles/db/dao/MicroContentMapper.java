package com.addoiles.db.dao;

import com.addoiles.dto.db.QueryMicroContentDto;
import com.addoiles.entity.MicroContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微内容Mapper
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/22 16:39
 */
public interface MicroContentMapper {

    int deleteByMicroId(@Param("microId")String microId);

    int insert(MicroContent record);

    int insertSelective(MicroContent record);

    MicroContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroContent record);

    int updateByPrimaryKey(MicroContent record);

    List<MicroContent> queryByDto(@Param("queryMicroContentDto") QueryMicroContentDto queryMicroContentDto);

}