package com.addoiles.dto.req;

/**
 * Description: 评论请求
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/3 13:58
 */
public class CommentReq {

    /**
     * tokenId
     */
    private String tokenId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 评论目标id
     */
    private String targetId;

    /**
     * 评论内容
     */
    private String content;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
