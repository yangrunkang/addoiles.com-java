package com.shamrock.cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.exception.ArticleNotFoundException;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.JsonVo;
import com.shamrock.cms.vo.PageVo;

@Controller
public class ArticleAction extends BaseAction{

	@ResponseBody
	@RequestMapping(value="/article/article_more.json",method=RequestMethod.POST)
	public JsonVo<PageVo<ArticleVo>> getMoreArticle(@RequestParam(value="pages")int pages,
			@RequestParam(value="rows")int rows,
			@RequestParam(value="folderId",required=false)Integer folderId){
		JsonVo<PageVo<ArticleVo>> json = new JsonVo<PageVo<ArticleVo>>();
		try {
			if(folderId==null){
				folderId = configService.getIntKey("shamrock_webId");
			}
			PageVo<ArticleVo> pageList = articleService.getArticlePageByFolderId(folderId, pages, rows);
			for(ArticleVo article:pageList.getList()){
				//截取长度
				article.setTitle(20);
			}
			json.setT(pageList);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
		}
		return json;
	} 
	
	@RequestMapping("/{folderEname}/{articleId}.htm")
	public String getContent(@PathVariable(value="folderEname")String ename,@PathVariable(value="articleId")long articleId,ModelMap modelMap){
		try {
			Folder folder = folderService.getFolderByEname(ename);
			ArticleVo article = articleService.getArticleById(articleId);
			modelMap.put("folder", folder);
			modelMap.put("article", article);
			modelMap.put("g_folderId", folderService.secondFolderId(folder.getFolderId()));
			return templateService.getArticleTemplate("index");
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			return templateService.get404();
		}
	}
	
}
