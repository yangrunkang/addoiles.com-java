package com.shamrock.cms.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shamrock.cms.constant.FolderConstant.Status;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.FolderVo;
import com.shamrock.cms.vo.PageVo;

@Controller
public class FolderAction extends BaseAction{
	
	@RequestMapping("/{folderEname}.htm")
	public String getFolderArticle(@PathVariable(value="folderEname")String ename,ModelMap modelMap){
		try {
			Folder folder = folderService.getFolderByEname(ename);
			if(folderService.firstFolderId(folder.getFolderId())!=configService.getIntKey("shamrock_webId")){
				throw new Exception("网页不存在！");
			}
			PageVo<ArticleVo> pageList = articleService.getArticlePageByFolderId(folder.getFolderId(), 1, 20);
			for(ArticleVo article:pageList.getList()){
				//截取长度
				article.setTitle(20);
			}
			List<FolderVo> folderList = folderService.getFolderListByFatherId(folder.getFolderId(), Status.display);
			modelMap.addAttribute("pages",1);
			modelMap.addAttribute("g_folderId",folderService.secondFolderId(folder.getFolderId()));
			modelMap.addAttribute("pageList",pageList);
			modelMap.addAttribute("folderList",folderList);
			modelMap.addAttribute("folderIds",folder.getFolderId());
			return templateService.getFolderTemplate("index");
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			modelMap.addAttribute("g_folderId", 0);
			return templateService.get404();
		}
	}
}
