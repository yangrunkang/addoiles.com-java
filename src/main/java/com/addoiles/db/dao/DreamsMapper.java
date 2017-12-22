package com.addoiles.db.dao;

import com.addoiles.common.Page;
import com.addoiles.entity.Dreams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Deprecated
public interface DreamsMapper {

    int deleteByDreamId(String dreamId);


    int insert(Dreams record);


    Dreams selectByPrimaryKey(Integer id);


    List<Dreams> selectAll(@Param("page") Page page);

    List<Dreams> selectByUserId(@Param("userId") String userId);

    int updateByPrimaryKey(Dreams record);
}