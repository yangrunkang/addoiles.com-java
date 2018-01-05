package com.addoiles.db.redis.dto;

import com.addoiles.entity.NavSettings;

import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/5 9:01
 */

public class NavDto {

    private List<NavSettings> navSettings;

    public List<NavSettings> getNavSettings() {
        return navSettings;
    }

    public void setNavSettings(List<NavSettings> navSettings) {
        this.navSettings = navSettings;
    }
}
