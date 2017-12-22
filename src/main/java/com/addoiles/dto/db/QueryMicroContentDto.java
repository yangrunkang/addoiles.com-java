package com.addoiles.dto.db;

import com.addoiles.common.Page;

/**
 * Description: 查询微内容Dto
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/22 17:04
 */
public class QueryMicroContentDto {

    /**
     * 分页对象
     */
    private Page page;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 微内容类型
     */
    private Integer microType;

    private String microId;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMicroType() {
        return microType;
    }

    public void setMicroType(Integer microType) {
        this.microType = microType;
    }

    public String getMicroId() {
        return microId;
    }

    public void setMicroId(String microId) {
        this.microId = microId;
    }
}
