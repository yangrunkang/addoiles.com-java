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
    public enum ArticleType {

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

        ArticleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 文章删除状态枚举
     */
    public enum ArticleDeleteStatus {

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

        ArticleDeleteStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 评论删除状态枚举
     */
    public enum CommentDeleteStatus {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        CommentDeleteStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 微内容类型枚举
     */
    public enum MicroContentType {

        /**
         * 热门动弹
         */
        HOTS(0),

        /**
         * 梦想
         */
        DREAMS(1),;

        private final int value;

        MicroContentType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 微内容删除状态枚举
     */
    public enum MicroContentDeleteStatus {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        MicroContentDeleteStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 导航栏是否启用枚举
     */
    public enum NavSettingsIsEnable {

        /**
         * 启用
         */
        ENABLE(0),

        /**
         * 不启用
         */
        NO_ENABLE(1),;

        private final int value;

        NavSettingsIsEnable(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 问题删除状态枚举
     */
    public enum QuestionDeletedStatus {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        QuestionDeletedStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 用户删除状态枚举
     */
    public enum UserDeletedStatus {

        /**
         * 正常
         */
        NORMAL(0),

        /**
         * 删除
         */
        DELETED(1),;

        private final int value;

        UserDeletedStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
