package com.addoiles.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Experience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Experience record);

    Experience selectByPrimaryKey(Integer id);

    List<Experience> selectExperienceList(@Param("page") Page page);

    int updateByPrimaryKey(Experience record);
}