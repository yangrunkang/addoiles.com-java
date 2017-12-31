package com.addoiles.dto;

import java.io.Serializable;

/** 图灵请求
 * Created by bla on 10/2/2017.
 */
public class TulingReq implements Serializable {

    private TulingReq(){}

    private String key;

    private String info;

    private String userid;

    private String api;

    public TulingReq(String key, String info, String userid, String api) {
        this.key = key;
        this.info = info;
        this.userid = userid;
        this.api = api;
    }

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
