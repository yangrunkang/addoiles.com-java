package com.addoiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexAction{

	@RequestMapping("index.html")
    public void test(){
        System.out.println("###########");
    }

    @RequestMapping
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");

        Map<String,String> map = new HashMap<String, String>();
        map.put("messageOne","你成功了！！！！！");

        modelAndView.addAllObjects(map);

        System.out.println("Default Mapping");
        return modelAndView;
    }


}
