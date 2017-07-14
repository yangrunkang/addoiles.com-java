package com.shamrock.cms.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shamrock.cms.constant.ConfigConstant;
import com.shamrock.cms.constant.SystemConstant;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.exception.TemplateNotFoundException;
import com.shamrock.cms.vo.FolderVo;

@Service("templateService")
public class TemplateService {
	private static String FOLDER_TEMPLATE_PREFIX = "folder";
	private static String FILE_TEMPLATE_PREFIX = "article";
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ConfigService configService;
	@Autowired
	private FolderService folderService;
	
	public String get404(){
		return this.getTemplatePath("404");
	}
	public String get500(){
		return this.getTemplatePath("500");
	}
	/**
	 * 获取首页
	 * @return
	 * @throws TemplateNotFoundException
	 */
	public String getDefaultTemplate() throws TemplateNotFoundException {
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add("index");
		themeOrderList.add(FOLDER_TEMPLATE_PREFIX);
		themeOrderList.add(FILE_TEMPLATE_PREFIX);
		for(String theme:themeOrderList){
			if(this.isExist(theme)){
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件：index不存在");
	}
	/**
	 * 得到文件夹模板
	 * @param folderId
	 * @return
	 * @throws Exception
	 */
	public String getFolderTemplate(long folderId) throws Exception{
		List<FolderVo> folderPathList = folderService.getFolderPathListByFolderId(folderId);
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add(FOLDER_TEMPLATE_PREFIX);
		String themString = FOLDER_TEMPLATE_PREFIX;
		for(Folder folder:folderPathList){
			themString = themString+"-"+folder.getEname();
			themeOrderList.add(themString);
		}
		Collections.reverse(themeOrderList);
		for(String theme:themeOrderList){
			if(this.isExist(theme)){
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件："+this.getTemplatePath(FOLDER_TEMPLATE_PREFIX)+".ftl 【不存在】");
		
	}
	/**
	 * 获取目录下的模板
	 * @param theme
	 * @return
	 * @throws Exception
	 */
	public String getFolderTemplate(String theme) throws Exception{
			String path = FOLDER_TEMPLATE_PREFIX+"/"+theme;
			if(this.isExist(path)){
				return this.getTemplatePath(path);
			}
			throw new TemplateNotFoundException("模板文件："+this.getTemplatePath(path)+".ftl 【不存在】");
		
	}
	
	/**
	 * 获取文章模板
	 * @param theme
	 * @return
	 * @throws Exception
	 */
	public String getArticleTemplate(String theme) throws Exception{
		String path = FILE_TEMPLATE_PREFIX+"/"+theme;
		if(this.isExist(path)){
			return this.getTemplatePath(path);
		}
		throw new TemplateNotFoundException("模板文件："+this.getTemplatePath(path)+".ftl 【不存在】");
	
}
	
	
	/**
	 * 得到文件模板
	 * @param folderId
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public String getArticleTemplate(long folderId,long articleId) throws Exception{
		List<FolderVo> folderPathList  = folderService.getFolderPathListByFolderId(folderId);
		List<String> themeOrdeList = new ArrayList<String>();
		themeOrdeList.add(FILE_TEMPLATE_PREFIX);
		String themeString = FILE_TEMPLATE_PREFIX;
		for(Folder folder:folderPathList){
			themeString = themeString+"-"+folder.getEname();
			themeOrdeList.add(themeString);
			
		}
		themeOrdeList.add(themeString+"-"+articleId);
		Collections.reverse(themeOrdeList);
		for(String theme:themeOrdeList){
			if(this.isExist(theme)){
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件:"+this.getTemplatePath(FILE_TEMPLATE_PREFIX)+" 【不存在】");
	}
	/**
	 * 模板物理地址是否存在
	 * @param theme
	 * @return
	 */
	@Cacheable("default")
	private boolean isExist(String theme) {
		String themePath = "/WEB-INF/static/template/"+configService.getStringByKey(ConfigConstant.SHAMROCK_TEMPLATE)+"/"+theme+".ftl";
		File file = new File(SystemConstant.SHAMROCK_CMS_ROOT+themePath);
		if(file.exists()){
			logger.info("尝试使用模板"+themePath+"【存在】");
			return true;
		}else{
			logger.info("尝试使用模板"+themePath+"【不存在】");
			return false;
		}
		
	}
	/**
	 * 得到当前请求需要渲染的模板相对路径
	 * @param template
	 * @return
	 */
	private String getTemplatePath(String template) {
		return "/template/"+configService.getStringByKey(ConfigConstant.SHAMROCK_TEMPLATE)+"/"+template;
	}
}
