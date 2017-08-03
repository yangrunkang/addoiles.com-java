package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.entity.OilArticle;
import com.addoiles.service.OilArticleService;
import com.addoiles.service.build.OilArticleBuilder;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 1-梦想 2-经历 3-最近难点 4-吐槽
 * author:      Yangrunkang
 * DateTime:  2017/8/3 10:25
 */
@Controller
public class OilArticleController {

    private static Logger logger = LoggerFactory.getLogger(OilArticleController.class);

    @Autowired
    private OilArticleService oilArticleService;


    @RequestMapping("addDream")
    @ResponseBody
    public OilResponse addDream(String dreamTitle,String dreamContent){
        OilResponse oilResponse = new OilResponse();
        try {
            OilArticle oilArticle = new OilArticle();
            OilArticleBuilder.buildDefaultOilArticle(oilArticle);
            oilArticle.setTitle(dreamTitle);
            oilArticle.setContent(dreamContent);
            oilArticleService.insert(oilArticle);
            oilResponse.setData(oilArticle);
        }catch (Exception e){
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.info("{}", JsonUtils.toJson(e));
        }

        return oilResponse;
    }


}
