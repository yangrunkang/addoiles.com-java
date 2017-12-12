package com.addoiles.db.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Experience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Experience record);

    Experience selectByPrimaryKey(Integer id);

    Experience selectByExperienceId(@Param("experienceId") String experienceId);

    List<Experience> selectByUserId(@Param("userId") String userId);

    List<Experience> selectExperienceList(@Param("page") Page page);

    int updateByExperienceId(Experience record);

    int updateSelectiveByExperienceId(Experience record);

}