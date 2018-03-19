package com.addoiles.exception;

import com.addoiles.common.ErrorCode;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 9:36
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 8130361585821557354L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String errorMsg;

    public BusinessException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.errorMsg = errorCode.getMessage();
    }

    public BusinessException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}