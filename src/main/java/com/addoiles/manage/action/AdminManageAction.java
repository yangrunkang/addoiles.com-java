package com.addoiles.manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.addoiles.entity.Admin;
import com.addoiles.vo.AdminFolderVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.addoiles.constant.SystemConstant;
import com.addoiles.vo.FolderVo;
import com.addoiles.vo.JsonVo;

/**
 * 
 * @author gunnyzeng
 *
 */
@Controller
@RequestMapping("/manage/admin")
public class AdminManageAction extends BaseManageAction{
	
	@RequestMapping(value="/manage.htm",method=RequestMethod.GET)
	public String manage(@RequestParam(value="page",defaultValue="1")int page,ModelMap modelMap) throws Exception{
		modelMap.put("pageVo", adminService.getAllListPage(page));
		return manageTemplateService.getAdminTemplate("manage");
	}
	
	@ResponseBody
	@RequestMapping(value="/addNew.json",method=RequestMethod.POST)
	public JsonVo<String> add(@RequestParam(value="adminName")String name,
			@RequestParam(value="password")String password){
		JsonVo<String> json = new JsonVo<String>();
		Admin admin = adminService.getAdminByName(name);
		if(admin!=null){
			json.getErrors().put("adminName", "该管理员已存在");
		}
		if(password.length()<6||password.length()>30){
			json.getErrors().put("password", "密码长度应为6-30之间");
		}
		try {
			validate(json);
			adminService.addAdmin(name, password);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="delete.json",method=RequestMethod.POST)
	public JsonVo<String> delete(@RequestParam(value="adminId")long adminId){
		JsonVo<String> json = new JsonVo<String>();
		try {
			adminService.deleteAdmin(adminId);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value="/permission/list.htm",method=RequestMethod.GET)
	public String adminFolder(@RequestParam(value="adminId")long adminId,ModelMap modelMap) throws Exception{
		List<AdminFolderVo> list = adminFolderService.getAdminFolderListById(adminId);
		List<FolderVo> folderAll = folderService.getAllFolderList(adminId);
		modelMap.put("admin", adminService.getAdminById(adminId));
		modelMap.put("list", list);
		modelMap.put("folderAll", folderAll);
		return manageTemplateService.getAdminTemplate("list");
	}
	
	@ResponseBody
	@RequestMapping(value="/permission/addFolder.json",method=RequestMethod.POST)
	public JsonVo<String> addAdminFolder(@RequestParam(value="adminId")long adminId,
			@RequestParam(value="folderId")long folderId){
		JsonVo<String> json = new JsonVo<String>();
		AdminFolderVo adminFolderVo = adminFolderService.getAdminFolderById(adminId, folderId);
		if(adminFolderVo==null){
			adminFolderService.addAdminFolder(adminId, folderId);
			json.setResult(true);
		}else{
			json.setResult(false);
			json.setMsg("管理员已拥有该权限");
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="permission/delete.json",method=RequestMethod.POST)
	public JsonVo<String> deleteAdminFolder(@RequestParam(value="adminId")long adminId,
			@RequestParam(value="folderId")long folderId){
		JsonVo<String> json = new JsonVo<String>();
		AdminFolderVo adminFolderVo = adminFolderService.getAdminFolderById(adminId, folderId);
		if(adminFolderVo!=null){
			adminFolderService.deleteAdminFolder(adminId, folderId);
			json.setResult(true);
		}else{
			json.setResult(false);
			json.setMsg("管理员未拥有该权限");
		}
		return json;
	}
	
	@RequestMapping(value="/update.htm",method=RequestMethod.GET)
	public String update(@RequestParam(value="adminId")long adminId,@RequestParam(value="page",defaultValue="1")int page,ModelMap modelMap) throws Exception{
		Admin admin = adminService.getAdminById(adminId);
		modelMap.put("admin", admin);
		modelMap.put("pageVo", adminService.getAllListPage(page));
		return manageTemplateService.getAdminTemplate("update");
	}
	
	@ResponseBody
	@RequestMapping(value="update.json",method=RequestMethod.POST)
	public JsonVo<String> update(@RequestParam(value="adminId")long adminId,
			@RequestParam(value="password")String password,HttpServletRequest request){
		JsonVo<String> json = new JsonVo<String>();
		if(password.length()<6||password.length()>30){
			json.getErrors().put("password", "密码长度6-30");
		}
		try {
			validate(json);
			adminService.updateAdminByAmdinId(adminId, password);
			Admin admin = adminService.getAdminById(adminId);
			//如果修改的用户为当前用户，则清除session重新登陆
			if(admin.getName().equals(getAdmin(request).getName())){
				request.getSession().removeAttribute(SystemConstant.SESSION_ADMIN);
			}
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
}
