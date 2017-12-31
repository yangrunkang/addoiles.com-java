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
     * 大小 todo 没加分页功能前先搞100个先用
     */
    private Integer pageSize = 100;


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
