package com.addoiles.common.enums;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 10:42
 */
public class AddoilesConstant {


    /**
     * 邮件类型
     */
    public enum EmailType {
        FORGET_PASSWORD(1, "忘记密码"),
        REGISTER(2, "新用户注册");


        private final Integer type;

        private final String desc;

        EmailType(Integer type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public Integer getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }
    }


}
