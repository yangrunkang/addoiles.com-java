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

    /**
     * 根据类型查询文章
     * @param type  1-梦想 2-经历 3-最近难点 4-吐槽
     * @param limitSize 查询数量
     * @return
     */
    List<OilArticle> selectsByType(Integer type,Integer limitSize);

    Integer insert(OilArticle oilArticle);

}
