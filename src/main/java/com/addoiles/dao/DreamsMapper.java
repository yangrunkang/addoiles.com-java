package com.addoiles.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Dreams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DreamsMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Dreams record);


    Dreams selectByPrimaryKey(Integer id);


    List<Dreams> selectAll(@Param("page")Page page);


    int updateByPrimaryKey(Dreams record);
}