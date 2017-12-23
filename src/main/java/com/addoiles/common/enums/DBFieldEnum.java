package com.addoiles.common.enums;

/**
 * Description: DB字段枚举
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/23 8:43
 */

public class DBFieldEnum {

    /**
     * 文章类型枚举
     */
    public enum ArticleTypeEnum {

        /**
         * 经历分享
         */
        EXPERIENCE(0),

        /**
         * 软件评测
         */
        SOFTWARE_TALK(1),

        /**
         * IT技术沉淀
         */
        IT_TECH(2),;

        private final int value;

        ArticleTypeEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 文章删除状态枚举
     */
    public enum ArticleDeleteStatusEnum {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),

        /**
         * 草稿
         */
        DRAFT(2),;

        private final int value;

        ArticleDeleteStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 评论删除状态枚举
     */
    public enum CommentDeleteStatusEnum {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        CommentDeleteStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 微内容类型枚举
     */
    public enum MicroContentTypeEnum {

        /**
         * 热门动弹
         */
        HOTS(0),

        /**
         * 梦想
         */
        DREAMS(1),;

        private final int value;

        MicroContentTypeEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 微内容删除状态枚举
     */
    public enum MicroContentDeleteStatusEnum {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        MicroContentDeleteStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 导航栏是否启用枚举
     */
    public enum NavSettingsIsEnableEnum {

        /**
         * 启用
         */
        ENABLE(0),

        /**
         * 不启用
         */
        NO_ENABLE(1),;

        private final int value;

        NavSettingsIsEnableEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 问题删除状态枚举
     */
    public enum QuestionDeletedStatusEnum {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        QuestionDeletedStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 用户删除状态枚举
     */
    public enum UserDeletedStatusEnum {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        UserDeletedStatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
