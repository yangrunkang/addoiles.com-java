package com.addoiles.dao;

import com.addoiles.entity.OilUser;

public interface OilUserMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilUser record);


    int insertSelective(OilUser record);


    OilUser selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OilUser record);


    int updateByPrimaryKey(OilUser record);
}