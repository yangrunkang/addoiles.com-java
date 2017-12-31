package com.addoiles.dto.req;

/**
 * Description: 评分Dto
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 11:13
 */

public class RatesDto {

    /**
     * 业务id
     */
    private String businessId;

    /**
     * 平分
     */
    private Integer rate;


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
