package com.addoiles.dto;

import java.io.Serializable;

/**
 * Created by bla on 10/3/2017.
 */
public class ExperienceRateReq implements Serializable {

    /**
     * 经历id
     */
    private String experienceId;

    /**
     * 评分
     */
    private Integer rate;

    public String getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(String experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
