package com.addoiles.entity;

import java.io.Serializable;

/**
 * 导航栏
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/1/4 18:09
 */
public class NavSettings implements Serializable {
    private Integer id;

    /**
     * 导航栏名称
     */
    private String navName;

    /**
     * 导航栏路由
     */
    private String navRouter;

    /**
     * 导航栏图标
     */
    private String navIcon;

    /**
     * 是否启用 0 -启用 1-不启用
     */
    private Integer isStart;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public String getNavRouter() {
        return navRouter;
    }

    public void setNavRouter(String navRouter) {
        this.navRouter = navRouter;
    }

    public String getNavIcon() {
        return navIcon;
    }

    public void setNavIcon(String navIcon) {
        this.navIcon = navIcon;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }
}