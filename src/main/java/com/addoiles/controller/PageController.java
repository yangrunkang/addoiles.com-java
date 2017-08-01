package com.addoiles.controller;
import com.addoiles.service.OilArticleService;
import com.addoiles.service.OilShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.addoiles.service.build.PageConstant.*;

@Controller
public class PageController {



    @Autowired
    private OilArticleService oilArticleService;

    @Autowired
    private OilShareService oilShareService;


    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName(HOME_PAGE);

        modelAndView.addObject("oilShares",oilShareService.selectHotShare());
        modelAndView.addObject("oilArticles",oilArticleService.selectsLatest());

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

    @RequestMapping(LOGIN_PAGE)
    public String login() {
        return "components/login/" + LOGIN_PAGE;
    }

    @RequestMapping(REGISTER_PAGE)
    public String register() {
        return "components/login/" + REGISTER_PAGE;
    }

    @RequestMapping("getCfeditor")
    public String tes() {
        return "components/cfeditor/cfeditor";
    }



}
