package com.addoiles.dao;

import com.addoiles.entity.Dreams;
import java.util.List;

public interface DreamsMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Dreams record);


    Dreams selectByPrimaryKey(Integer id);


    List<Dreams> selectAll();


    int updateByPrimaryKey(Dreams record);
}