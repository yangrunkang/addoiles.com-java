package com.addoiles.db.dao;

import com.addoiles.entity.MicroContent;

/**
 * 微内容Mapper
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/22 16:39
 */
public interface MicroContentMapper extends BaseMapper{

    int insertSelective(MicroContent record);

}