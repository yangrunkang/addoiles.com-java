package com.addoiles.controller;

import com.addoiles.entity.OilArticle;
import com.addoiles.entity.OilShare;
import com.addoiles.service.OilArticleService;
import com.addoiles.service.OilShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    private static final String HOME_PAGE = "home";
    private static final String ADDOIL_PAGE = "addoil";
    private static final String COMPLAINT_PAGE = "complaint";
    private static final String DIFFICULT_PAGE = "difficult";
    private static final String EXPERENCE_PAGE = "experence";
    private static final String FOURM_PAGE = "fourm";
    private static final String DREAMS_PAGE = "dreams";


    @Autowired
    private OilArticleService oilArticleService;

    @Autowired
    private OilShareService oilShareService;


    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName(HOME_PAGE);

        List<OilShare> oilShares = oilShareService.selectHotShare();
        List<OilArticle> oilArticles = oilArticleService.selectsLatest();


        modelAndView.addObject("oilShares",oilShares);
        modelAndView.addObject("oilArticles",oilArticles);

        return modelAndView;
    }

    @RequestMapping(ADDOIL_PAGE)
    public String addoil() {
        return ADDOIL_PAGE;
    }

    @RequestMapping(COMPLAINT_PAGE)
    public String complaint() {
        return COMPLAINT_PAGE;
    }

    @RequestMapping(DIFFICULT_PAGE)
    public String difficult() {
        return DIFFICULT_PAGE;
    }

    @RequestMapping(EXPERENCE_PAGE)
    public String experence() {
        return EXPERENCE_PAGE;
    }

    @RequestMapping(FOURM_PAGE)
    public String fourm() {
        return FOURM_PAGE;
    }

    @RequestMapping(DREAMS_PAGE)
    public String dreams() {
        return DREAMS_PAGE;
    }


}
