package com.addoiles.entity;

/**
 * Created by bla on 10/3/2017.
 */
public class Suggest {

    private Integer id;

    /**
     * 用户id
     */
    private String userId;


    /**
     * 内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
