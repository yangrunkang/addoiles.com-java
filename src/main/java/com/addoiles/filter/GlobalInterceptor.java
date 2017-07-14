package com.addoiles.filter;

import org.apache.log4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("globalInterceptor")
public class GlobalInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		if(null == modelAndView){
			return;
		}
		String basePath = HttpUtils.getBasePath(request);
		modelAndView.addObject("BASE_PATH",basePath);
		modelAndView.addObject("UPLOAD_BASE_PATH",basePath+"/upload");
		modelAndView.addObject("TEMPLATE_MANAGE_PATH",basePath+"/static/template/manage");
		MDC.put("ip", HttpUtils.getIp(request));
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		return true;
	}

}
