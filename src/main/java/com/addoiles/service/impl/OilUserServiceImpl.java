package com.addoiles.service.impl;

import com.addoiles.dao.OilUserMapper;
import com.addoiles.entity.OilUser;
import com.addoiles.service.OilUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 * Copyright:   Copyright(C) 2017
 * Company:     HQYG.
 * author:      Yangrunkang
 * Createdate:  2017/7/18 17:37
 */
@Service
public class OilUserServiceImpl implements OilUserService {

    @Autowired
    private OilUserMapper oilUserMapper;


    @Override
    public Integer logout(String email, String password) {

        return null;
    }

    @Override
    public Integer login(String email, String password) {

        return null;
    }

    @Override
    public Integer register(OilUser oilUser) {
        return oilUserMapper.insert(oilUser);
    }
}
