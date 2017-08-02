package com.addoiles.filter;

import com.addoiles.util.HttpUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("globalInterceptor")
public class GlobalInterceptor implements HandlerInterceptor {

    private String pageName;

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {


    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (null == modelAndView) {
            return;
        }
        String viewName = modelAndView.getViewName();
        modelAndView.addObject("base_url", HttpUtils.getBasePath(request));
        modelAndView.addObject("project_name", request.getContextPath()); // eg. /path

        if(SourceNameFilter.filterSourceUrls.contains(viewName)) {
           //url在过滤器里面
        }else{
            pageName = viewName;
        }
        modelAndView.addObject("pageName",pageName);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        return true;
    }

}
