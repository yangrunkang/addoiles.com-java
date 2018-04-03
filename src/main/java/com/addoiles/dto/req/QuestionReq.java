package com.addoiles.dto.req;

/**
 * Description: 问题请求
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/3 14:01
 */
public class QuestionReq {

    /**
     * userId
     */
    private String userId;

    /**
     * tokenId
     */
    private String tokenId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
