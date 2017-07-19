package com.addoiles.dao;

import com.addoiles.entity.OilShare;

public interface OilShareMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilShare record);


    int insertSelective(OilShare record);


    OilShare selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OilShare record);


    int updateByPrimaryKey(OilShare record);
}