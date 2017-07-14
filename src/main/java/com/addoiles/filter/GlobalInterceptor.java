package com.addoiles.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addoiles.service.FolderService;
import com.addoiles.util.HttpUtils;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.addoiles.constant.ConfigConstant;
import com.addoiles.constant.SystemConstant;
import com.addoiles.service.ConfigService;

@Component("globalInterceptor")
public class GlobalInterceptor implements HandlerInterceptor{
	@Autowired
	private ConfigService configService;
	@Autowired
	private FolderService folderfigService;
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		if(null == modelAndView){
			return;
		}
		String basePath = HttpUtils.getBasePath(request);
		modelAndView.addObject("BASE_PATH",basePath);
		modelAndView.addObject("UPLOAD_BASE_PATH",basePath+"/upload");
		modelAndView.addObject("BOOTSTRAP_PATH",basePath+"/static/"+SystemConstant.BOOTSTRAP_PATH);
		modelAndView.addObject("TEMPLATE_BASE_PATH",basePath+"/static/template/"+configService.getStringByKey(ConfigConstant.SHAMROCK_TEMPLATE));
		modelAndView.addObject("TEMPLATE_MANAGE_PATH",basePath+"/static/template/manage");
		modelAndView.addObject("WEBID",configService.getIntKey("shamrock_webId"));
		modelAndView.addObject("shamrock_seo_title",configService.getStringByKey("shamrock_seo_title"));
		modelAndView.addObject("LOGO",folderfigService.getFolderById(configService.getIntKey("shamrock_webId")).getLogo());
		modelAndView.addObject("shamrock_seo_description",configService.getStringByKey("shamrock_seo_description"));
		MDC.put("ip", HttpUtils.getIp(request));
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		return true;
	}

}
