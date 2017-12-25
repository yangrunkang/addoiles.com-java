package com.addoiles.dto.db;

/**
 * Description: 查询微内容Dto
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/22 17:04
 */
public class QueryMicroContentDto extends BaseQueryDto{

    /**
     * 微内容类型
     */
    private Integer microType;

    private String microId;

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
