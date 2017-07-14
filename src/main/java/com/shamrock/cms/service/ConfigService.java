package com.shamrock.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shamrock.cms.dao.ConfigDao;
import com.shamrock.cms.entity.Config;

@Service("configService")
public class ConfigService {
	@Autowired
	private ConfigDao configDao;
	
	/**
	 * 增加配置
	 * @param key
	 * @param value
	 * @return
	 */
	public Config addConfig(String key,String value){
		Config config = new Config();
		config.setKey(key);
		config.setValue(value);
		config.setCreateTime(new Date());
		configDao.addConfig(config);
		return config;
		
	}
	/**
	 * 删除配置
	 * @param key
	 * @return
	 */
	@CacheEvict(value="config")
	public int deleteConfigByKey(String key){
		return configDao.deleteConfig(key);
	}
	
	/**
	 * 更新配置
	 * @param key
	 * @param value
	 * @return
	 */
	@CacheEvict(value="config",allEntries=true)
	public Config updateConfigByKey(String key,String value){
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		configDao.updateConfig(config);
		this.getStringByKey(key);
		return config;
	}
	/**
	 * 获取配置
	 * @param key
	 * @return
	 */
	@Cacheable(value="config")
	public String getStringByKey(String key){
		Config config = configDao.getConfigByKey(key);
		if(config==null){
			return "";
		}else{
			return config.getValue();
		}
	}
	/**
	 * 获取配置，并将字符串数字转换成整数
	 * @param key
	 * @return
	 */
	@Cacheable(value="config")
	public int getIntKey(String key){
		Config config = configDao.getConfigByKey(key);
		if(config == null){
			return 0;
		}else{
			return Integer.parseInt(config.getValue());
		}
	}
	/**
	 * 获取网站所有配置
	 * @return
	 */
	public List<Config>  getAllConfig(){
		return configDao.getAllConfig();
	}
}
