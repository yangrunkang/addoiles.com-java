package com.addoiles.controller;

import com.addoiles.dao.OilShareMapper;
import com.addoiles.entity.OilShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 热门动弹
 * All rights Reserved, Designed By HQYG
 * Copyright:   Copyright(C) 2017
 * Company:     HQYG.
 * author:      Yangrunkang
 * Createdate:  2017/7/19 15:41
 */
@Controller
public class OilShareController {

    @Autowired
    private OilShareMapper oilShareMapper;

    @RequestMapping("share")
    @ResponseBody
    private Object share(){

        return null;
    }

}
