package com.addoiles.dao;

import com.addoiles.entity.Experience;
import java.util.List;

public interface ExperienceMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Experience record);


    Experience selectByPrimaryKey(Integer id);


    List<Experience> selectAll();


    int updateByPrimaryKey(Experience record);
}