package com.addoiles.dto.req;

import java.io.Serializable;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/6/28 14:44
 */
public class UserLatestActivityReq implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * TokenId
     */
    private String tokenId;


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
}
