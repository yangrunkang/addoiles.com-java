package com.addoiles.action;

import com.addoiles.exception.FolderNotFoundException;
import com.addoiles.vo.PageVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.addoiles.vo.ArticleVo;

@Controller
public class IndexAction extends BaseAction{
	/**
	 * 默认首页
	 * @param pages
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String defaultRequest(
			@RequestParam(value="pages",defaultValue="1")int pages,
			ModelMap modelMap
			){
		return home(pages,modelMap);
	}
	/**
	 * 首页
	 * @param pages
	 * @param modelMap
	 * @return
	 * @throws FolderNotFoundException
	 */
	@RequestMapping(value="/index.htm",method=RequestMethod.GET)
	public String home(@RequestParam(value="pages",defaultValue="1")int pages,ModelMap modelMap){
		try {
			int webId = configService.getIntKey("shamrock_webId");
			String path = folderService.getFolderById(webId).getPath();
			PageVo<ArticleVo> pageList = articleService.getArticlePage(path,pages, 20);
			for(ArticleVo article:pageList.getList()){
				//截取长度
				article.setTitle(20);
			}
			modelMap.addAttribute("pages",pages);
			modelMap.addAttribute("g_folderId",0);
			modelMap.addAttribute("pageList",pageList);
			modelMap.addAttribute("folderIds", webId);
			return templateService.getDefaultTemplate();
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			return templateService.get404();
		}
	}
	
	
	
	/**
	 * 404页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/404.htm",method=RequestMethod.GET)
	public String pageNotFound(@RequestParam(value="pages",defaultValue="1")int pages,ModelMap modelMap){
		modelMap.addAttribute("pages",pages);
		modelMap.addAttribute("g_folderId",0);
		return templateService.get404();
	}
	/**
	 * 500页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/500.htm",method=RequestMethod.GET)
	public String serverError(@RequestParam(value="pages",defaultValue="1")int pages,ModelMap modelMap){
		modelMap.addAttribute("pages",pages);
		modelMap.addAttribute("g_folderId",0);
		return templateService.get500();
	}
	
}
