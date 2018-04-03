package com.addoiles.dto.req;

import java.io.Serializable;

/**
 * 图灵请求
 * Created by bla on 10/2/2017.
 */
public class TulingReq implements Serializable {

    private String key;

    private String info;

    private String userId;

    private String tokenId;

    private String api;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
