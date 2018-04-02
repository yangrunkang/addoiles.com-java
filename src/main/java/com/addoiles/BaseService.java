package com.addoiles;

import com.addoiles.dto.business.QueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 基础服务
 * <p>Service和Mapper共用</p>
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/25 14:56
 */

public interface BaseService<T> {

    /**
     * 添加
     * @param t
     * @return
     */
    Integer insert(T t);

    /**
     * 根据businessId
     * @param businessId
     * @return
     */
    Integer delete(String businessId);

    /**
     * 更新
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 根据businessId获取
     * @param businessId 除表id外的实体id,比如User表中的userId,Article表的articleId
     * @return
     */
    T getByBusinessId(String businessId);


    /**
     * 获取列表
     * @param queryDto
     * @return
     */
    List<T> getList(@Param("queryDto")QueryDto queryDto);

}
