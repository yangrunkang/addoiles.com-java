package com.addoiles.controller;

import com.addoiles.common.OilResponse;
import com.addoiles.entity.OilArticle;
import com.addoiles.service.OilArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Description: 1-梦想 2-经历 3-最近难点 4-吐槽
 * author:      Yangrunkang
 * DateTime:  2017/8/3 10:25
 */
@Controller
public class OilArticleController {

    @Autowired
    private OilArticleService oilArticleService;


    public OilResponse getDreams(Integer type, Integer limitSize, ModelAndView modelAndView){

        List<OilArticle> oilArticles = oilArticleService.selectsByType(type, limitSize);
        return null;
    }


}
