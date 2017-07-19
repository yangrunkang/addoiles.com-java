package com.addoiles.dao;

import com.addoiles.entity.OilShare;

import java.util.List;

public interface OilShareMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilShare record);


    int insertSelective(OilShare record);


    OilShare selectByPrimaryKey(String id);

    List<OilShare> selectHotShare();


    int updateByPrimaryKeySelective(OilShare record);


    int updateByPrimaryKey(OilShare record);
}