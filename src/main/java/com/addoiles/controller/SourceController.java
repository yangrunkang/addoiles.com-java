package com.addoiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description: 资源Controller,用于获取各种资源
 * author:      Yangrunkang
 * DateTime:  2017/8/2 8:59
 */
@Controller
public class SourceController {

    /**
     * 获取编辑器
     * @param pageName 来源页面
     * @return
     */
    @RequestMapping("getCfeditor")
    public String getCfeditor(String pageName, ModelAndView modelAndView) {
        return "components/cfeditor/cfeditor";
    }


}
