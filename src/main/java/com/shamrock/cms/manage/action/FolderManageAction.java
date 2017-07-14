package com.shamrock.cms.manage.action;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shamrock.cms.constant.FolderConstant;
import com.shamrock.cms.entity.Admin;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.exception.TemplateNotFoundException;
import com.shamrock.cms.exception.ValidateException;
import com.shamrock.cms.util.RegexUtils;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.FolderVo;
import com.shamrock.cms.vo.JsonVo;
/**
 * 后台目录管理
 * @author GunnyZeng
 *
 */
@Controller
@RequestMapping("/manage/folder")
public class FolderManageAction extends BaseManageAction{
	/**
	 * 目录列表
	 * @param folderId
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.htm",method=RequestMethod.GET)
	public String list(@RequestParam(value="folderId",required=false)Long folderId,HttpServletRequest request,ModelMap modelMap) throws Exception{
		if(folderId==null||folderId==0){
			folderId = (long) configService.getIntKey("shamrock_webId");
		}
		List<FolderVo> pathList = folderService.getFolderPathListByFolderId(folderId);
		Folder folder = new Folder();
		folder = folderService.getFolderById(folderId);
		
		Admin admin = this.getAdmin(request);
		List<FolderVo> folderList = folderService.getFolderListByFatherId(folderId, null);
		modelMap.put("folder", folder);
		modelMap.put("folderList", folderList);
		modelMap.put("pathList", pathList);
		modelMap.put("folderName", "");
		modelMap.put("folderEname", "");
		modelMap.put("folderAll", folderService.getAllFolderList(admin.getAdminId()));
		try {
			return manageTemplateService.getFolderTemplate("list");
		} catch (TemplateNotFoundException e) {
			logger.fatal(e.getMessage());
			return manageTemplateService.get404();
		}
	}
	@ResponseBody
	@RequestMapping(value="/add.json",method=RequestMethod.POST)
	public JsonVo<String> add(@RequestParam(value="fatherId",defaultValue="0")long fatherId,
			@RequestParam(value="folderName")String folderName,
			@RequestParam(value="folderEname")String folderEname,
			@RequestParam(value="status")FolderConstant.Status status,
			@RequestParam(value="check")FolderConstant.Check check,
			ModelMap modelMap){
		JsonVo<String> json = new JsonVo<String>();
		folderName = folderName.trim();
		folderEname = folderEname.toLowerCase();
		if(StringUtils.isBlank(folderName)){
			json.getErrors().put("folderName", "目录名称不能为空");
		}else if(!RegexUtils.isAlphaUnderline(folderEname)){
			json.getErrors().put("folderEname", "只能是英文字母，数字和下划线");
		}else if(folderService.isFolderByEname(folderEname)){
			json.getErrors().put("folderEname", "该英文目录名已存在");
		}
		try {
			validate(json);
			folderService.addFolder(fatherId, folderName, folderEname, status, check);
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value="/update.htm",method=RequestMethod.GET)
	public String update(@RequestParam(value="folderId",defaultValue="0")long folderId,
			HttpServletRequest request,ModelMap modelMap) throws Exception{
		Admin admin = this.getAdmin(request);
		FolderVo folder = folderService.getFolderById(folderId);
		modelMap.put("folder", folder);
		modelMap.put("folderAll", folderService.getFolderOtherList(admin.getAdminId(),folderId));
		modelMap.put("JSESSIONID", request.getSession().getId());
		return manageTemplateService.getFolderTemplate("update");
	}
	
	@ResponseBody
	@RequestMapping(value="/update.json",method=RequestMethod.POST)
	public JsonVo<String> update(@RequestParam(value="folderId")long folderId,
			@RequestParam(value="fatherId")long fatherId,
			@RequestParam(value="name")String name,
			@RequestParam(value="ename")String ename,
			@RequestParam(value="newfatherId")long newfatherId,
			@RequestParam(value="height")int height,
			@RequestParam(value="width")int width,
			@RequestParam(value="status")FolderConstant.Status status,
			@RequestParam(value="content",required=false)String content,
			HttpServletRequest request){
		JsonVo<String> jsonVo = new JsonVo<String>();
		name = name.trim();
		ename = ename.toLowerCase();
		Admin admin = getAdmin(request);
		try {
			Folder folder = folderService.getFolderByEname(ename);
			if(folder.getFolderId()!=folderId){
				jsonVo.getErrors().put("folderEname", "该英文名目录已存在");
				jsonVo.setResult(false);
				return jsonVo;
			}
		} catch (FolderNotFoundException e) {
			
		}
		try {
		//所属目录更改，则相应子目录及文章路径也要相应更改
		if(fatherId!=newfatherId&&folderId!=newfatherId){
				String fatherpath = folderService.getFolderById(newfatherId).getPath();
				String path = fatherpath+folderId+"#";
				//更新当前目录的父id和path
				int level = path.split("#").length;
				folderService.updateFatherIdPathLevel(folderId, newfatherId, path,level);
				//更新该目录的文章path
				articleService.updatePath(folderId, path);
				
				List<FolderVo> folderList = folderService.getAllFolderList(admin.getAdminId());
				String match = "#"+folderId+"#";
				//更新子目录及文章的path
				for(FolderVo folders : folderList){
					if(folders.getOwner().equals("yes")&&folders.getFolderId()!=folderId&&folders.getPath().indexOf(match)!=-1){
						path=fatherpath+folders.getPath().substring(folders.getPath().indexOf(match));
						//更新目录path
						level = path.split("#").length;
						folderService.updatePathLevel(folderId, path,level);
						//更新文章path
						articleService.updatePath(folders.getFolderId(), path);
					}
				}
			}
			folderService.updateFolderById(folderId, name, ename, status, content, height, width);
			jsonVo.setResult(true);
		} catch (Exception e) {
			jsonVo.setResult(false);
			jsonVo.setMsg(e.getMessage());
		}
		return jsonVo;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete.json",method=RequestMethod.POST)
	public JsonVo<String> delete(@RequestParam(value="folderId")long folderId) throws Exception{
		JsonVo<String> json = new JsonVo<String>();
		List<FolderVo> folderList = folderService.getFolderListByFatherId(folderId, null);
		int articleCount = articleService.getArticleCountByFolderId(folderId);
		if(folderId==configService.getIntKey("shamrock_webId")){
			json.setResult(false);
			json.setMsg("该网站当前正在运行，请禁用状态再删除！");
		}else if((folderList!=null&&folderList.size()>0)||(articleCount>0)){
			json.setResult(false);
			json.setMsg("该目录不为空，不能删除！");
			
		}else{
			folderService.deteleFolderById(folderId);
			json.setResult(true);
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/sort.json",method=RequestMethod.POST)
	public JsonVo<String> sort(@RequestParam(value="sortJson")String sortJson){
		JsonVo<String> json = new JsonVo<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<LinkedHashMap<String, String>> list = objectMapper.readValue(sortJson, List.class);
			for(LinkedHashMap<String, String> folders:list){
				int folderId = Integer.parseInt(folders.get("folderId"));
				int sort = Integer.parseInt(folders.get("sort"));
				folderService.updateSort(folderId, sort);
			}
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		} 
		return json;
	}
}
