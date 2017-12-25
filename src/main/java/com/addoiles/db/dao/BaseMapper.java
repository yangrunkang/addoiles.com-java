package com.addoiles.db.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 基础服务
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/25 14:56
 */

public interface BaseMapper<T> {

    /**
     * 添加
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据businessId
     * @param businessId
     * @return
     */
    int delete(String businessId);

    /**
     * 更新
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 根据businessId获取
     * @param businessId
     * @return
     */
    T get(String businessId);

    /**
     * 获取列表
     * @param baseQueryDto
     * @return
     */
    List<T> getList(@Param("queryMicroContentDto")Object baseQueryDto);

}
