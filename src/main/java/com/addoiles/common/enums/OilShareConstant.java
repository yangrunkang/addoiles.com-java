package com.addoiles.common.enums;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 14:59
 */
public enum OilShareConstant {
    /**
     * 正常
     */
    NORMAL(0),

    /**
     * 已删除
     */
    DELETED(1),;

    private final int value;

    OilShareConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

