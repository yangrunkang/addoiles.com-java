package com.addoiles.service;

import com.addoiles.entity.OilUser;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 * Copyright:   Copyright(C) 2017
 * Company:     HQYG.
 * author:      Yangrunkang
 * Createdate:  2017/7/18 17:33
 */
public interface OilUserService {

    /**
     * 注册
     */
    Integer register(OilUser oilUser);

    /**
     * 登录
     */
    Integer login(String email, String password);

    /**
     * 登出
     * session
     */
    Integer logout(String email, String password);

}
