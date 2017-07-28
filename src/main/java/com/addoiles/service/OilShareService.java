package com.addoiles.service;

import com.addoiles.entity.OilShare;

import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 9:26
 */
public interface OilShareService {

    /**
     * 最新动态
     * @return
     */
    List<OilShare> selectHotShare();

}
