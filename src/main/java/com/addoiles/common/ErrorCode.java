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
public enum  ErrorCode {
    SUCCESS(0, "success"),
    PARAMETER_ERROR(1, "参数错误"),
    SYSTEM_ERROR(2, "系统异常"),
    LOGIN_FAILED(3,"登录失败"),
    REGISTER_FAILED(4,"注册失败"),
    LOG_OUT_FAILED(5,"注销失败"),
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
