package com.shamrock.cms.manage.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.shamrock.cms.constant.SystemConstant;
import com.shamrock.cms.entity.Headline;
import com.shamrock.cms.exception.ValidateException;
import com.shamrock.cms.service.AdminFolderService;
import com.shamrock.cms.service.AdminService;
import com.shamrock.cms.service.ArticleService;
import com.shamrock.cms.service.ConfigService;
import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.service.HeadlineService;
import com.shamrock.cms.service.ManageTemplateService;
import com.shamrock.cms.service.MediaService;
import com.shamrock.cms.vo.AdminVo;
import com.shamrock.cms.vo.JsonVo;

public class BaseManageAction {
	protected final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	protected ConfigService configService;
	@Autowired
	protected FolderService folderService;
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected MediaService mediaService;
	@Autowired
	protected AdminService adminService;
	@Autowired
	protected HeadlineService headline;
	@Autowired
	protected AdminFolderService adminFolderService;
	@Autowired
	protected ManageTemplateService manageTemplateService;
	/**
	 * 参数校验
	 * @param json
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if(json.getErrors().size()>0){
			json.setResult(false);
			throw new ValidateException("系统发生错误");
		}else{
			json.setResult(true);
		}
	}
	/**
	 * 从sessio获取管理员信息
	 * @param request
	 * @return
	 */
	protected AdminVo getAdmin(HttpServletRequest request){
		AdminVo admin = (AdminVo) request.getSession().getAttribute(SystemConstant.SESSION_ADMIN);
		return admin;
	}
}
