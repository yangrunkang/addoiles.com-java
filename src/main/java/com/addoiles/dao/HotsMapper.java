package com.addoiles.dao;

import com.addoiles.entity.Hots;
import java.util.List;

public interface HotsMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Hots record);


    Hots selectByPrimaryKey(Integer id);


    List<Hots> selectAll();


    int updateByPrimaryKey(Hots record);
}