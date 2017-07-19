package com.addoiles.controller;

import com.addoiles.entity.OilUser;
import com.addoiles.service.OilUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexAction{

    @Autowired
    private OilUserService oilUserService;

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

    @RequestMapping("register")
    public ModelAndView register(ModelAndView modelAndView){
        modelAndView.setViewName("index");

        OilUser oilUser = new OilUser();
        oilUser.setId("12341234");
        oilUser.setEmail("ashdha@qq.com");
        oilUser.setUserName("232");

        Integer register = oilUserService.register(oilUser);

        Map<String,String> map = new HashMap<String, String>();
        map.put("messageOne","注册成功" + register);

        modelAndView.addAllObjects(map);


        return modelAndView;
    }

}
