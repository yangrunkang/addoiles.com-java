package com.addoiles.db.redis.dto;

import com.addoiles.entity.Recommend;

import java.util.List;

/**
 * 推荐信息Dto
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/1/8 9:08
 */
public class RecommendDto {

    private List<Recommend> recommendList;

    public List<Recommend> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Recommend> recommendList) {
        this.recommendList = recommendList;
    }
}
