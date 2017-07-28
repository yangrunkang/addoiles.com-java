package com.addoiles.common.enums;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 14:59
 */
public enum OilUserConstant {
    /**
     * 正常
     */
    NORMAL(1),

    /**
     * 删除
     */
    DELETED(0),;

    private final int value;

    OilUserConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

