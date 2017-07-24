package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.common.enums.OilShareConstant;
import com.addoiles.dao.OilShareMapper;
import com.addoiles.entity.OilShare;
import com.addoiles.util.JsonUtils;
import com.addoiles.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 热门动弹
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/19 15:41
 */
@Controller
public class OilShareController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OilShareMapper oilShareMapper;

    @RequestMapping("share")
    @ResponseBody
    private Object share(OilShare oilShare) {
        OilResponse oilResponse = new OilResponse();
        try {
            oilShare.setCreateTime(TimeUtil.currentTime());
            oilShare.setDeleteStatus(OilShareConstant.NORMAL.getValue());
            oilShareMapper.insert(oilShare);
            oilResponse.setData(oilShare); //返回到页面
        } catch (Exception e) {
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.info("{}", JsonUtils.toJson(e));
        }
        return oilResponse;
    }

}
