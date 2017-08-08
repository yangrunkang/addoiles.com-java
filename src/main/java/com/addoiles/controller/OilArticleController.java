package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.common.enums.OilArticleConstant;
import com.addoiles.entity.OilArticle;
import com.addoiles.entity.OilText;
import com.addoiles.service.OilArticleService;
import com.addoiles.service.OilTextService;
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

    @Autowired
    private OilTextService oilTextService;


    @RequestMapping("addDream")
    @ResponseBody
    public OilResponse addDream(String dreamTitle, String dreamContent) {
        OilResponse oilResponse = new OilResponse();
        try {
            OilArticle oilArticle = new OilArticle();
            OilArticleBuilder.buildOilArticle(oilArticle, OilArticleConstant.Type.DREAM.getValue());
            oilArticle.setTitle(dreamTitle);
            oilArticle.setContent(dreamContent);
            oilArticleService.insert(oilArticle);
            oilResponse.setData(oilArticle);
        } catch (Exception e) {
            e.printStackTrace();
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.error("{}", JsonUtils.toJson(e));
        }

        return oilResponse;
    }

    @RequestMapping("addExperence")
    @ResponseBody
    public OilResponse addExperence(String content, String title) {
        OilResponse oilResponse = new OilResponse();
        try {
            OilArticle oilArticle = new OilArticle();
            OilArticleBuilder.buildOilArticle(oilArticle, OilArticleConstant.Type.EXPERENCE.getValue());
            oilArticle.setTitle(title);
            oilArticle.setContent(content);
            //关联到oil_text
            OilText oilText = new OilText();
            oilText.setArticleId(oilArticle.getArticleId());
            oilText.setContent(content);
            oilArticleService.insert(oilArticle);
            oilTextService.insert(oilText);

            oilResponse.setData(oilArticle);
        } catch (Exception e) {
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.error("{}", e.getMessage());
        }
        return oilResponse;
    }


}
