package com.addoiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private static final String HOME_PAGE = "home";
    private static final String ADDOIL_PAGE = "addoil";
    private static final String COMPLAINT_PAGE = "complaint";
    private static final String DIFFICULT_PAGE = "difficult";
    private static final String EXPERENCE_PAGE = "experence";
    private static final String FOURM_PAGE = "fourm";
    private static final String DREAMS_PAGE = "dreams";


    @RequestMapping
    public String home() {
        return HOME_PAGE;
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
