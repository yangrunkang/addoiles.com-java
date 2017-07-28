package com.addoiles.service;

import com.addoiles.entity.OilArticle;

import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:26
 */
public interface OilArticleService {
    /**
     * 最近文章
     * @return
     */
    List<OilArticle> selectsLatest();

}
