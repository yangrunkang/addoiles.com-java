package com.addoiles.db.dao;

import com.addoiles.entity.NavSettings;

import java.util.List;

public interface NavSettingsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(NavSettings record);

    int insertSelective(NavSettings record);

    NavSettings selectByPrimaryKey(Integer id);

    List<NavSettings> selectAll();

    int updateByPrimaryKeySelective(NavSettings record);

    int updateByPrimaryKey(NavSettings record);
}