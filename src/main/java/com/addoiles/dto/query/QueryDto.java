package com.addoiles.dto.query;

import com.addoiles.common.Page;

/**
 * Description: Base查询对象
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/25 14:58
 */
public class QueryDto {

    /**
     * 分页对象
     */
    private Page page;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 业务id
     * 除表id外的实体id,比如User表中的userId,Article表的articleId
     * @return
     */
    private String businessId;



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
}
