package com.addoiles.util;



import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;





public class PropertyUtils extends PropertyPlaceholderConfigurer{
	public static final Logger logger = Logger.getLogger(PropertyUtils.class);
	private static Map<String, String> propertyMap;
	
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props){
		super.processProperties(beanFactoryToProcess, props);
		propertyMap = new HashMap<String, String>();
		for(Object key:props.keySet()){
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			propertyMap.put(keyStr,value);
		}
	}
	
	public static String getValue(String name){
		String value = propertyMap.get(name);
		if(StringUtils.isBlank(value)){
			return "";
		}else{
			return value;
		}
	}
	

}
