package com.shamrock.cms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.util.HttpUtils;
import com.shamrock.cms.util.PropertyUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * folder标签
 * 
 * @author GunnyZeng
 * 
 */
@Service("folderUrlTag")
public class FolderUrlTag extends BaseTag {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String ename = params.get("ename").toString();
		String basePath = HttpUtils.getBasePath(request);
		if (Boolean.getBoolean(configService.getStringByKey("shamrock.static"))) {
			env.getOut().write(basePath + "/html/folder/" + ename + ".html");
		} else {
			env.getOut().write(basePath + "/" + ename + ".htm");
		}
	}

}
