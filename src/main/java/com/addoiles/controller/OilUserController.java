package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.entity.OilUser;
import com.addoiles.service.OilUserService;
import com.addoiles.service.build.OilUserBuilder;
import com.addoiles.service.build.PageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

import static com.addoiles.service.build.PageConstant.HOME_PAGE;
import static com.addoiles.service.build.PageConstant.LOGIN_PAGE;

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
    public Object register(ModelAndView modelAndView, OilUser oilUser) {
        OilResponse oilResponse = new OilResponse();

        modelAndView.setViewName(PageConstant.HOME_PAGE);

        Integer register = oilUserService.register(OilUserBuilder.buildDefaultOilUser(oilUser));
        // TODO: 2017/7/28 回显到导航栏上,在过滤器中写 暂时session存储
        if(register > 0){
            oilResponse.setData(oilUser);
        }else {
            oilResponse.setErrorCode(ErrorCode.REGISTER_FAILED);
        }

        return new OilResponse(register > 0);
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public ModelAndView userLogin(String email, String password,ModelAndView modelAndView) {
        OilResponse oilResponse;

        OilUser oilUser = oilUserService.login(email, password);

        if (Objects.isNull(oilUser)) {
            modelAndView.setViewName("components/login/" + LOGIN_PAGE);
        } else {
            modelAndView.setViewName(HOME_PAGE);
            modelAndView.addObject("oilUser",oilUser);
            // TODO: 2017/7/28 后期隐藏url账户密码信息 
        }

        return modelAndView;
    }


}
