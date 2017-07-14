package com.shamrock.cms.manage.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;
import com.shamrock.cms.util.PropertyUtils;

@Controller
@RequestMapping("/manage")
public class UEditorAction extends BaseManageAction{
	/**
	 * ueditor 配置文件
	 * @param action
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/ueditor.htm")
	public String config(@RequestParam(value="action")String action,HttpServletResponse response,HttpServletRequest request){
		String root = PropertyUtils.getRoot()+File.separatorChar;
		logger.info("ueditor root:"+root);
		return new ActionEnter(request, root).exec();
	}
}
