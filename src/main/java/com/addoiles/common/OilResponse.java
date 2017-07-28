package com.addoiles.common;

import java.io.Serializable;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/20 8:59
 */
public class OilResponse implements Serializable{

    private static final long serialVersionUID = 3468809980704226548L;
    private Integer code = Integer.valueOf(0);
    private String message = "success";
    private Object data;

    public OilResponse() {
    }

    public OilResponse(Integer code) {
        this.code = code;
    }

    public OilResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public OilResponse(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public OilResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public OilResponse(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
