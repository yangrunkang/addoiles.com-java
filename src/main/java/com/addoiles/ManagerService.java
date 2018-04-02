package com.addoiles;

import com.addoiles.dto.business.QueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 用户管理界面接口
 * All rights Reserved, Designed By HQYG
 *
 * @author yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/28 14:49
 */

public interface ManagerService<T> {
    /**
     * 获取用户资料简洁信息
     * @param queryDto
     * @return
     */
    List<T> getSimpleList(@Param("queryDto")QueryDto queryDto);

    /**
     * 获取总数
     * @param queryDto
     * @return
     */
    Integer getTotalCount(@Param("queryDto")QueryDto queryDto);

}
