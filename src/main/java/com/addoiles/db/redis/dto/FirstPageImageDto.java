package com.addoiles.db.redis.dto;

import com.addoiles.entity.FirstPage;

import java.util.List;

/**
 * 首页图片
 */
public class FirstPageImageDto {

    private List<FirstPage> firstPageList;

    public List<FirstPage> getFirstPageList() {
        return firstPageList;
    }

    public void setFirstPageList(List<FirstPage> firstPageList) {
        this.firstPageList = firstPageList;
    }
}
