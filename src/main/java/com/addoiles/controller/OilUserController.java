package com.addoiles.controller;

import com.addoiles.entity.OilUser;
import com.addoiles.service.OilUserService;
import com.addoiles.service.build.OilUserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

import static com.addoiles.common.PageConstant.LOGIN_PAGE;

/**
 * Description:
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2017
 * Company:     .
 * author:      Yangrunkang
 * Createdate:  2017/7/19 14:03
 */
@Controller
public class OilUserController {

    @Autowired
    private OilUserService oilUserService;


    @RequestMapping("userRegister")
    @ResponseBody
    public ModelAndView register(ModelAndView modelAndView, OilUser oilUser) {
        Integer register = oilUserService.register(OilUserBuilder.buildDefaultOilUser(oilUser));
        if(register > 0){
            modelAndView.addObject("tips","注册成功,请登录~O(∩_∩)O哈哈~");
            //注册成功重定向到登录
            modelAndView.setViewName("components/login/" + LOGIN_PAGE);
        }else {
            //重定向到首页
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping("userLogin")
    public ModelAndView userLogin(String email, String password,ModelAndView modelAndView) {

        OilUser oilUser = oilUserService.login(email, password);

        if (Objects.isNull(oilUser)) {
            modelAndView.setViewName("redirect:components/login/" + LOGIN_PAGE);
        } else {
            modelAndView.addObject("oilUser",oilUser);
            modelAndView.setViewName("forward:");
        }
        return modelAndView;

    }


}
