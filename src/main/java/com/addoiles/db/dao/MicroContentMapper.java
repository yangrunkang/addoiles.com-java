package com.addoiles.db.dao;

import com.addoiles.entity.MicroContent;

public interface MicroContentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MicroContent record);

    int insertSelective(MicroContent record);

    MicroContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroContent record);

    int updateByPrimaryKey(MicroContent record);
}