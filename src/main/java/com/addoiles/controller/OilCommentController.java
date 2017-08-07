package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.entity.OilComment;
import com.addoiles.service.OilCommentService;
import com.addoiles.service.build.OilCommentBuilder;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 评论
 * DateTime:  2017/8/7 20:25
 */
@Controller
public class OilCommentController {

    private static Logger logger = LoggerFactory.getLogger(OilCommentController.class);

    @Autowired
    private OilCommentService oilCommentService;

    @RequestMapping("commit")
    @ResponseBody
    public OilResponse commit(OilComment oilComment){
        OilResponse oilResponse = new OilResponse();
        try {
            OilCommentBuilder.buildOilComment(oilComment);
            oilCommentService.insert(oilComment);
            oilResponse.setData(oilComment); //不能写oilResponse本身,会报Could not write content: Direct self-reference leading to cycle的错误
        }catch (Exception e){
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.error("{}", e.getMessage());
        }
        return oilResponse;
    }


}
