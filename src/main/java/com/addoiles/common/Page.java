package com.addoiles.common;

/**
 * Created by bla on 9/30/2017.
 */
public class Page {

    /**
     * 页数
     */
    private Integer pageNo = 0;


    /**
     * 大小
     */
    private Integer pageSize = 20;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
