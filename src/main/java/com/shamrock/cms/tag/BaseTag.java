package com.shamrock.cms.tag;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.shamrock.cms.constant.SystemConstant;
import com.shamrock.cms.service.ConfigService;
import com.shamrock.cms.util.SSUtils;

import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;

/**
 * freemaker自定义标签基类
 * @author GunnyZeng
 *
 */
public abstract class BaseTag extends ApplicationObjectSupport implements TemplateDirectiveModel{
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	protected ConfigService configService;
	
	@PostConstruct
	public void init() throws BeansException, TemplateModelException, IllegalStateException{
		String classNamePath = this.getClass().getName();
		String className = classNamePath.substring(classNamePath.lastIndexOf(".")+1);
		String beanName = StringUtils.uncapitalize(className);//将类名第一个小写作为bean的名字
		String tagName = SystemConstant.TAGHEAD+"_"+SSUtils.toUnderline(beanName);//将驼峰变为_小写
		logger.info(tagName);
		freeMarkerConfigurer.getConfiguration().setSharedVariable(tagName, this.getApplicationContext().getBean(beanName));
		
	}
}
