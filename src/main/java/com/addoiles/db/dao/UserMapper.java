package com.addoiles.db.dao;

import com.addoiles.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(User record);


    User selectByUserId(String userId);


    List<User> selectAll();


    int updateByUserId(User record);

    /**
     * 根据邮箱查找用户
     * @param email
     * @return
     */
    List<User> countByEmail(@Param("email")String email,@Param("password")String password);

    /**
     * 检查注册用户是否已已经注册过
     * @param email
     * @return
     */
    Integer checkHasRegister(@Param("email")String email);

    /**
     * 获取用户id和Name
     * @return
     */
    List<User> getUsersOfIdNameList();



}