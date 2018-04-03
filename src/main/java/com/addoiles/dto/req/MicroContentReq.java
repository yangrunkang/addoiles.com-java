package com.addoiles.dto.req;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/3 14:04
 */
public class MicroContentReq {

    /**
     * 用户id
     */
    private String userId;

    /**
     * tokenId
     */
    private String tokenId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 微内容类型
     */
    private Integer microType;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMicroType() {
        return microType;
    }

    public void setMicroType(Integer microType) {
        this.microType = microType;
    }
}
