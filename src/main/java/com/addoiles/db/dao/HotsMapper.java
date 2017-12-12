package com.addoiles.db.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Hots;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotsMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Hots record);


    Hots selectByPrimaryKey(Integer id);


    List<Hots> selectAll(@Param("page") Page page);

    List<Hots> selectByUserId(@Param("page") Page page,@Param("userId")String userId);


    int updateByPrimaryKey(Hots record);


}