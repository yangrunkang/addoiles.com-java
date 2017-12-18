package com.addoiles.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/18 17:03
 */
public class SpringContextUtils implements ApplicationContextAware{

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext){
		SpringContextUtils.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	
	/**
	 * 通过 id 从spring中获取bean
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException{
		
		return applicationContext.getBean(name);
		
	}
	
	/**
	 * 通过类型 从spring中bean
	 * @param clazz
	 * @return
	 * @throws BeansException
	 */
	public static <T> T getBean(Class<T> clazz) throws BeansException{
		
		return applicationContext.getBean(clazz);
		
	}
	
	/**
	 * 通过id和类型获取spring bean
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		
		return applicationContext.getBean(name, clazz);
		
	}
	
}