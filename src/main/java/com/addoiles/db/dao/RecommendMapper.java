package com.addoiles.db.dao;

import com.addoiles.BaseService;
import com.addoiles.entity.Recommend;

import java.util.List;

/**
 * 推荐信息
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/1/8 9:03
 */
public interface RecommendMapper extends BaseService<Recommend>{

    int selectMaxId();

    /**
     * 获取推荐列表
     * @return
     */
    List<Recommend> getFirstPageImageList();


}