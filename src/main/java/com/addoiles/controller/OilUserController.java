package com.addoiles.controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.entity.OilUser;
import com.addoiles.exception.BusinessException;
import com.addoiles.service.OilUserService;
import com.addoiles.service.build.OilUserBuilder;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    private static Logger logger = LoggerFactory.getLogger(OilUserController.class);

    @Autowired
    private OilUserService oilUserService;


    @RequestMapping("userRegister")
    @ResponseBody
    public ModelAndView register(ModelAndView modelAndView, OilUser oilUser, HttpSession session) {
        Integer register = oilUserService.register(OilUserBuilder.buildDefaultOilUser(oilUser));
        if (register > 0) {
            modelAndView.addObject("tips", "注册成功,请登录~O(∩_∩)O哈哈~");
            //注册成功重定向到登录
            modelAndView.setViewName("components/login/" + LOGIN_PAGE);
        } else {
            //重定向到首页
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping("userLogin")
    public ModelAndView userLogin(String email, String password, ModelAndView modelAndView, HttpSession session) {

        OilUser oilUser = oilUserService.login(email, password);

        if (Objects.isNull(oilUser)) {
            modelAndView.setViewName("redirect:components/login/" + LOGIN_PAGE);
        } else {
            session.setAttribute("user",oilUser); //保存到session
            session.setMaxInactiveInterval(30*60); //存活30分钟
            modelAndView.setViewName("forward:");
        }
        return modelAndView;

    }

    @RequestMapping("logout")
    @ResponseBody
    public OilResponse logout(String userId, HttpServletRequest request){
        OilResponse oilResponse = new OilResponse();
        try{
            OilUser user = (OilUser) request.getSession().getAttribute("user");
            if(Objects.isNull(user)){
                throw new BusinessException(ErrorCode.LOG_OUT_FAILED);
            }
            if(Objects.isNull(userId)){
                throw new BusinessException(ErrorCode.PARAMETER_ERROR);
            }

            if(user.getUserId().equals(userId)){
                request.getSession().setAttribute("user",null);
            }
        }catch (BusinessException ex){
            logger.error(JsonUtils.toJson(ex));
            oilResponse.setErrorCode(ex.getErrorCode());
        }catch (Exception e){
            logger.error(JsonUtils.toJson(e));
            oilResponse.setCode(ErrorCode.SYSTEM_ERROR.getCode());
            oilResponse.setMessage(JsonUtils.toJson(e));
            logger.error("{}", e.getMessage());
        }
        return oilResponse;
    }



}
