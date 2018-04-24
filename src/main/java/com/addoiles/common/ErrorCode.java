package com.addoiles.common;

import com.addoiles.exception.BusinessException;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 9:35
 */
public enum ErrorCode {
    SUCCESS(0, "SUCCESS"),
    PARAMETER_ERROR(1, "参数错误"),
    SYSTEM_ERROR(2, "系统异常"),
    LOGIN_FAILED(3, "登录失败"),
    REGISTER_FAILED(4, "注册失败"),
    LOG_OUT_FAILED(5, "注销失败"),
    ILLEGAL_REQUEST(6, "非法请求"),
//    EXPERIENCE_NOT_EXISTS(7, "该分享不存在"),
    ARTICLE_NOT_EXISTS(8, "文章不存在"),
    TOKEN_ID_USER_ID_NULL(9, "token_id or user_id is null"),
    UPLOAD_FILE_NULL(10, "上传文件为空"),
    UPLOAD_IMG_FAILED(11, "文件上传错误"),
    JUST_SUPPORT_IMAGE(12, "仅支持图片格式文件(.jpg|.png,|.gif|.jpeg),请重新选择"),
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误对应异常类
     */
    private BusinessException exception;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.exception = new BusinessException(this);
    }

    public static ErrorCode getErrorCodeByCode(Integer code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (code.equals(errorCode.getCode())) {
                return errorCode;
            }
        }
        return null;
    }


    /**
     * 获取错误代码
     *
     * @return
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 获取错误信息
     *
     * @return
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 获取错误异常类
     *
     * @return
     */
    public BusinessException getException() {
        return exception;
    }

}
