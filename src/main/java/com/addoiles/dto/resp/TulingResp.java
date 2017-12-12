package com.addoiles.dto.resp;

import java.io.Serializable;

/**
 * Created by bla on 10/2/2017.
 */
public class TulingResp implements Serializable {

    private Integer code;

    private String text;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
