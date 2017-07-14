package com.shamrock.cms.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.service.ArticleService;
import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.FolderVo;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service("articleListTag")
public class ArticleListTag extends BaseTag{
	@Autowired
	private ArticleService articleService;
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer folderId = Integer.parseInt(params.get("folderId").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		try {
			FolderVo folder = folderService.getFolderById(folderId);
			List<ArticleVo> articlelist = articleService.getArticleListOfDisplayByPath(folder.getPath(), 0, rows);
			env.setVariable("tag_article_list", ObjectWrapper.BEANS_WRAPPER.wrap(articlelist));
		} catch (FolderNotFoundException e) {
			env.setVariable("tag_article_list", ObjectWrapper.BEANS_WRAPPER.wrap(null));
		}
		body.render(env.getOut());
	}

}
