package com.addoiles.filter;

import com.addoiles.entity.OilUser;
import com.addoiles.util.HttpUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component("globalInterceptor")
public class GlobalInterceptor implements HandlerInterceptor {

    private String pageName;
    private String baseUrl;

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {


    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        this.handleModelAndView(modelAndView, request);
        this.handleSession(request.getSession(), modelAndView);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        return true;
    }


    /**
     * 处理ModelAndView
     */
    private void handleModelAndView(ModelAndView modelAndView, HttpServletRequest request) {
        if (null == modelAndView) {
            return;
        }
        String viewName = modelAndView.getViewName();
        String baseUrl = HttpUtils.getBasePath(request);
        modelAndView.addObject("base_url", baseUrl);
        modelAndView.addObject("project_name", request.getContextPath()); // eg. /path
        if (SourceNameFilter.filterSourceUrls.contains(viewName)) {
            //url在过滤器里面
        } else {
            pageName = viewName;
            this.baseUrl = baseUrl;
        }
        modelAndView.addObject("pageName", pageName);
    }

    /**
     * 处理session
     */
    private void handleSession(HttpSession session, ModelAndView modelAndView) {

        if(modelAndView == null) return; //解决ajax请求,modelAndView为空,导致ajax无返回结果的问题

        OilUser user = (OilUser)session.getAttribute("user");
        //user_bar主要负责用户登录注销状态工作
        if(Objects.nonNull(user)){
            modelAndView.addObject("user_bar",loginOk(user.getUserName()));
        }else{
            modelAndView.addObject("user_bar",noUser());
        }
    }

    /***
     * 登录成功时,展示用户名
     * TODO 后期会展示其他信息
     * @param userName
     * @return
     */
    private String loginOk(String userName) {
        //TODO 超链接做注销功能
        return "<ul class='nav navbar-nav navbar-right'><li><a href='#'><span class='glyphicon glyphicon-log-in'></span>" + userName + "</a></li><li><a href='#注销功能'><span class='glyphicon glyphicon-user'></span>注销</a></li></ul>";
    }

    private String noUser(){
        return "<ul class='nav navbar-nav navbar-right'><li><a href='"+this.baseUrl+"/register'><span class='glyphicon glyphicon-user'></span> 注册</a></li><li><a href='"+this.baseUrl+"/login'><span class='glyphicon glyphicon-log-in'></span> 登录</a></li></ul>";
    }

}
