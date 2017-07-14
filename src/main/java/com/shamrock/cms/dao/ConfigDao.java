package com.shamrock.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shamrock.cms.entity.Config;

/**
 * 网站配置
 * 
 * @author GunnyZeng
 * 
 */

@Repository("configDao")
public interface ConfigDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加配置
	 * 
	 * @return Integer
	 */
	public int addConfig(Config config);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除配置
	 * 
	 * return Integer
	 */
	public int deleteConfig(@Param("key") String key);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 更新配置
	 * 
	 * @return Integer
	 */
	public int updateConfig(Config config);

	/**
	 * 查询所有配置
	 * @return
	 */
	public List<Config>  getAllConfig();
	/**
	 * 查看配置
	 * 
	 * @return Config
	 */
	public Config getConfigByKey(@Param("key") String key);
}
