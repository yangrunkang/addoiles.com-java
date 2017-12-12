package com.addoiles.common.enums;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 14:59
 */
public class OilArticleConstant {

    /**
     * 删除状态
     */
    public enum DeleteStatus {

        /**
         * 正常
         */
        NORMAL(1),

        /**
         * 删除
         */
        DELETED(0),;

        private final int value;

        DeleteStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 类型
     */
    public enum Type {
        DREAM(1),
        EXPERENCE(2),
        DIFFICULT(3),
        COMPLAINT(4),;

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}

