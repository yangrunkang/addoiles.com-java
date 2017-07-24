package com.addoiles.common;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 9:35
 */
public enum  ErrorCode {
    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 参数错误
     */
    PARAMETER_ERROR(30001, "参数错误"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(30002, "系统繁忙"),

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
