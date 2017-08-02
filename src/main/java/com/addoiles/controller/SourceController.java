package com.addoiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 资源Controller,用于获取各种资源
 * author:      Yangrunkang
 * DateTime:  2017/8/2 8:59
 */
@Controller
public class SourceController {

    /**
     * 拿到编辑器
     * @return
     */
    @RequestMapping("getCfeditor")
    public String tes() {
        return "components/cfeditor/cfeditor";
    }


}
