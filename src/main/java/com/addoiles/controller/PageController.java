package com.addoiles.controller;

import com.addoiles.dao.OilArticleMapper;
import com.addoiles.dao.OilShareMapper;
import com.addoiles.entity.OilArticle;
import com.addoiles.entity.OilShare;
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
    private OilShareMapper oilShareMapper;


    @Autowired
    private OilArticleMapper oilArticleMapper;

    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName(HOME_PAGE);

        List<OilShare> oilShares = oilShareMapper.selectHotShare();
        List<OilArticle> oilArticles = oilArticleMapper.selectsLatest();


        modelAndView.addObject("oilShares",oilShares);
        modelAndView.addObject("oilArticles",oilArticles);

        return modelAndView;
    }

    @RequestMapping("addoil")
    public String addoil() {
        return ADDOIL_PAGE;
    }

    @RequestMapping("complaint")
    public String complaint() {
        return COMPLAINT_PAGE;
    }

    @RequestMapping("difficult")
    public String difficult() {
        return DIFFICULT_PAGE;
    }

    @RequestMapping("experence")
    public String experence() {
        return EXPERENCE_PAGE;
    }

    @RequestMapping("fourm")
    public String fourm() {
        return FOURM_PAGE;
    }

    @RequestMapping("dreams")
    public String dreams() {
        return DREAMS_PAGE;
    }


}
