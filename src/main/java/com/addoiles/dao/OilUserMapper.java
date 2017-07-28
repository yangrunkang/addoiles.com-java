package com.addoiles.dao;

import com.addoiles.entity.OilUser;
import org.apache.ibatis.annotations.Param;

public interface OilUserMapper {

    int deleteByPrimaryKey(String id);


    int insert(OilUser record);


    int insertSelective(OilUser record);


    OilUser selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OilUser record);


    int updateByPrimaryKey(OilUser record);

    OilUser login(@Param("email")String email,@Param("password")String password);

}