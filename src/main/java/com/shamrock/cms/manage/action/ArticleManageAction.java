package com.shamrock.cms.manage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shamrock.cms.constant.ArticleConstant;
import com.shamrock.cms.constant.ArticleConstant.Check;
import com.shamrock.cms.constant.MediaConstant;
import com.shamrock.cms.entity.Admin;
import com.shamrock.cms.entity.Article;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.entity.Media;
import com.shamrock.cms.exception.ArticleNotFoundException;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.exception.TemplateNotFoundException;
import com.shamrock.cms.exception.UploadException;
import com.shamrock.cms.util.SSUtils;
import com.shamrock.cms.vo.AdminVo;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.FolderVo;
import com.shamrock.cms.vo.JsonVo;
import com.shamrock.cms.vo.PageVo;

/**
 * 文章方面
 * @author GunnyZeng
 *
 */
@Controller
@RequestMapping("/manage/article")
public class ArticleManageAction extends BaseManageAction{
	/**
	 * 文章列表
	 * @param pageNum
	 * @param folderId
	 * @param check
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.htm",method=RequestMethod.GET)
	public String list(@RequestParam(value="pages",defaultValue="1")int pageNum,
			@RequestParam(value="folderId",defaultValue="0")long folderId,
			@RequestParam(value="check",required=false)ArticleConstant.Check check,
			HttpServletRequest request,ModelMap modelMap) throws Exception{
		Admin admin = this.getAdmin(request);
		long adminId = admin.getAdminId();
		if(folderId==0){
			folderId = configService.getIntKey("shamrock_webId");
		}
		List<FolderVo> pathList = folderService.getFolderPathListByFolderId(folderId); 
		PageVo<ArticleVo> pageVo = articleService.getArticlePageByFolderId(adminId,folderId,check,pageNum);
		int initCount = articleService.getArticleCountByAdminIdAndFolderId(adminId, folderId, Check.init);
		int noCount = articleService.getArticleCountByAdminIdAndFolderId(adminId, folderId, Check.no);
		int allCount = initCount+noCount+articleService.getArticleCountByAdminIdAndFolderId(adminId, folderId, Check.yes);
		modelMap.put("pathList", pathList);
		modelMap.put("folderId", folderId);
		modelMap.put("pageVo",pageVo);
		modelMap.put("pages", pageNum);
		modelMap.put("initCount", initCount);
		modelMap.put("noCount", noCount);
		modelMap.put("allCount", allCount);
		try {
			return manageTemplateService.getArticleTemplate("list");
		} catch (TemplateNotFoundException e) {
			logger.fatal(e.getMessage());
			modelMap.addAttribute("g_folderId", 0);
			return manageTemplateService.get404();
		}
	}
	
	/**
	 * 更改文件审核状态
	 * @param articleId
	 * @param check
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/check.json",method=RequestMethod.POST)
	public JsonVo<String> check(
			@RequestParam(value="articleId")long articleId,
			@RequestParam(value="check")ArticleConstant.Check check,
			HttpServletRequest request){
		JsonVo<String> json = new JsonVo<String>();
		AdminVo admin = this.getAdmin(request);
		if(!admin.getIsAdmin()){
			json.setResult(false);
			json.setMsg("您不是超级管理员，无审核权限");
		}else{
			articleService.updateCheck(articleId, check);
			json.setResult(true);
		}
		return json;
	}
	/**
	 * 编辑文章
	 * @param articleId
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update.htm",method=RequestMethod.GET)
	public String update(
			@RequestParam(value="articleId",defaultValue="1") long articleId,
			ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Admin admin = this.getAdmin(request);
		ArticleVo article = articleService.getArticleById(articleId);
		modelMap.put("article", article);
		modelMap.put("folderAll", folderService.getAllFolderList(admin.getAdminId()));
		modelMap.put("JSESSIONID", request.getSession().getId());
		try {
			return manageTemplateService.getArticleTemplate("update");
		} catch (TemplateNotFoundException e) {
			logger.fatal(e.getMessage());
			modelMap.addAttribute("g_folderId", 0);
			return manageTemplateService.get404();
		}
	}
	/**
	 * 编辑文章
	 * @param articleId
	 * @param folderId
	 * @param title
	 * @param summary
	 * @param content
	 * @param updateTime
	 * @param status
	 * @param picture
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update.json",method=RequestMethod.POST)
	public JsonVo<Article> update(
			@RequestParam(value="articleId")long articleId,
			@RequestParam(value="folderId")long folderId,
			@RequestParam(value="title")String title,
			@RequestParam(value="summary")String summary,
			@RequestParam(value="content")String content,
			@RequestParam(value="updateTime",required=false)String updateTime,
			@RequestParam(value="status")ArticleConstant.Status status,
			@RequestParam(value="picture",required=false)MultipartFile picture,
			HttpServletRequest request,ModelMap modelMap) {
		JsonVo<Article> json = new JsonVo<Article>();
		try {
			Article article = articleService.updateArticle(articleId, folderId, this.getAdmin(request).getAdminId(), SSUtils.toText(title.trim()), SSUtils.toText(summary), content, status, picture, updateTime);
			json.setT(article);
			json.setResult(true);
			return json;
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
		}
		json.setResult(false);
		return json;
	}
	/**
	 * 删除文章，包括其附件
	 * @param articleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete.json",method=RequestMethod.POST)
	public JsonVo<String> deleteArticle(@RequestParam(value="articleId")long articleId){
		JsonVo<String> json = new JsonVo<String>();
		articleService.deleteArticleById(articleId);
		List<Media> attachmentList = mediaService.getMediaPageByKindId(articleId, MediaConstant.Kind.article, 1000, 1).getList();
		for(Media attachment :attachmentList){
			mediaService.deleteMedia(attachment.getMediaId(), attachment.getPath());
		}	
		json.setResult(true);
		return json;
	}
	/**
	 * 增加文章页面
	 * @param folderId
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add.htm",method=RequestMethod.GET)
	public String add(@RequestParam(value="folderId",defaultValue="0")long folderId,
			HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		Admin admin = this.getAdmin(request);
		modelMap.put("folderAll",folderService.getAllFolderList(admin.getAdminId()));
		modelMap.put("folderId", folderId);
		try {
			return manageTemplateService.getArticleTemplate("add");
		} catch (TemplateNotFoundException e) {
			logger.fatal(e.getMessage());
			return manageTemplateService.get404();
		}
	}
	/**
	 * 添加文章
	 * @param folderId
	 * @param title
	 * @param summary
	 * @param content
	 * @param createTime
	 * @param status
	 * @param picture
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add.json",method=RequestMethod.POST)
	public JsonVo<Article> add(
			@RequestParam("folderId")long folderId,
			@RequestParam("title")String title,
			@RequestParam(value="summary",required=false)String summary,
			@RequestParam(value="content")String content,
			@RequestParam(value="createTime",required=false)String createTime,
			@RequestParam("status")ArticleConstant.Status status,
			@RequestParam(value="picture",required=false)MultipartFile picture,
			HttpServletRequest request,ModelMap modelMap){
		JsonVo<Article> json = new JsonVo<Article>();
		Article article;
		try {
			article = articleService.addArticle(folderId, this.getAdmin(request).getAdminId(), title, summary, status, content, picture, createTime);
			json.setT(article);
			json.setResult(true);
			return json;
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		json.setResult(false);
		return json;
	}
	/**
	 * 文章预览
	 * @param articleId
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/preview.htm",method=RequestMethod.GET)
	public String preview(@RequestParam(value="articleId")long articleId,HttpServletRequest request,ModelMap modelMap){
		try {
			ArticleVo article = articleService.getArticleById(articleId);
			//article.setStatus(ArticleConstant.Status.display);
			Folder folder = folderService.getFolderById(article.getFolderId());
			modelMap.put("pages", article.getFolderId());
			modelMap.put("folder", folder);
			modelMap.put("article", article);
			modelMap.put("g_folderId", folderService.firstFolderId(folder.getFolderId()));
			return manageTemplateService.getArticleTemplate(article.getFolderId(), articleId);
		} catch (Exception e) {
			modelMap.addAttribute("g_folderId",0);
			return manageTemplateService.get404();
		}
		
	}
}
