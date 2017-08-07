package com.addoiles.controller;

import com.addoiles.common.enums.OilArticleConstant;
import com.addoiles.entity.OilArticle;
import com.addoiles.entity.OilText;
import com.addoiles.service.OilArticleService;
import com.addoiles.service.OilShareService;
import com.addoiles.service.OilTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

import static com.addoiles.common.PageConstant.*;

/**
 * 点击导航栏第一次进入时,主要做初始化显示的
 */
@Controller
public class PageController {


    @Autowired
    private OilArticleService oilArticleService;

    @Autowired
    private OilShareService oilShareService;

    @Autowired
    private OilTextService oilTextService;


    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName(HOME_PAGE);

        modelAndView.addObject("oilShares", oilShareService.selectHotShare());
        modelAndView.addObject("oilArticles", oilArticleService.selectsLatest(OilArticleConstant.Type.EXPERENCE.getValue()));

        return modelAndView;
    }

//    @RequestMapping(ADDOIL_PAGE)
//    public String addoil() {
//        return ADDOIL_PAGE;
//    }
//
//    @RequestMapping(COMPLAINT_PAGE)
//    public String complaint() {
//        return COMPLAINT_PAGE;
//    }
//
//    @RequestMapping(DIFFICULT_PAGE)
//    public String difficult() {
//        return DIFFICULT_PAGE;
//    }

    @RequestMapping(EXPERENCE_PAGE)
    public ModelAndView experence(ModelAndView modelAndView) {
        modelAndView.setViewName(EXPERENCE_PAGE);
        List<OilArticle> experenceArticles = oilArticleService.selectsLatest(OilArticleConstant.Type.EXPERENCE.getValue());
        experenceArticles.forEach(oilArticle -> {
            //OilArticleConstant.Type.EXPERENCE这个类型的,都会关联 oil_text表
            OilText oilText = oilTextService.selectByArticleId(oilArticle.getArticleId());
            if(Objects.nonNull(oilText)){
                oilArticle.setOilText(oilText);
            }
        });
        modelAndView.addObject("oilExperenceList",experenceArticles);
        return modelAndView;
    }

    @RequestMapping(FOURM_PAGE)
    public String fourm() {
        return FOURM_PAGE;
    }

    @RequestMapping(DREAMS_PAGE)
    public ModelAndView dreams(ModelAndView modelAndView) {

        List<OilArticle> oilArticles = oilArticleService.selectsByType(OilArticleConstant.DeleteStatus.NORMAL.getValue(), 100);
        //均分
        Integer articleSize = oilArticles.size();
        Integer columnSize = 3; //左-中-右 3栏

        Integer avgPerColumn = articleSize / columnSize;
        Integer modNum = articleSize % columnSize;
        if (modNum >= 0) { //取余大于0,余数放在最后一栏
            modelAndView.addObject("leftDreams", oilArticles.subList(0, avgPerColumn));
            modelAndView.addObject("midDreams", oilArticles.subList(avgPerColumn, avgPerColumn * 2));
            modelAndView.addObject("rightDreams", oilArticles.subList(avgPerColumn * 2, avgPerColumn * 3 + modNum));
            // TODO: 2017/8/3 余数应该均分到三列,否则会导致最后一列过长,稍后解决
        }
        modelAndView.setViewName(DREAMS_PAGE);
        return modelAndView;
    }

    @RequestMapping(LOGIN_PAGE)
    public String login() {
        return "components/login/" + LOGIN_PAGE;
    }

    @RequestMapping(REGISTER_PAGE)
    public String register() {
        return "components/login/" + REGISTER_PAGE;
    }


}
