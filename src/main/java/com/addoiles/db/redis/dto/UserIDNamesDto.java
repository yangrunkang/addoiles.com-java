package com.addoiles.db.redis.dto;

import com.addoiles.entity.User;

import java.util.List;

/**
 * Description: 所有用户的ID-NAME集合
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 17:11
 */

public class UserIDNamesDto {

    private List<User> userIdNameList;

    public List<User> getUserIdNameList() {
        return userIdNameList;
    }

    public void setUserIdNameList(List<User> userIdNameList) {
        this.userIdNameList = userIdNameList;
    }
}
