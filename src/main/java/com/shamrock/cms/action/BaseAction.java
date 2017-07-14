package com.shamrock.cms.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.shamrock.cms.service.ArticleService;
import com.shamrock.cms.service.ConfigService;
import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.service.TemplateService;

public class BaseAction {
	protected final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	protected TemplateService templateService;
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected FolderService folderService;
	@Autowired
	protected ConfigService configService;
}
