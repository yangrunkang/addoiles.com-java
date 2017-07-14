package com.shamrock.cms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.util.HttpUtils;

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
@Service("articleUrlTag")
public class ArticleUrlTag extends BaseTag {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		String artcleId = params.get("articleId").toString();
		String basePath = HttpUtils.getBasePath(request);
		env.getOut().write(basePath + "/article/" + artcleId + ".htm");
	}

}
