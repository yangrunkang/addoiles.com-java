package com.shamrock.cms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.service.ArticleService;
import com.shamrock.cms.service.FolderService;
import com.shamrock.cms.vo.ArticleVo;
import com.shamrock.cms.vo.PageVo;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

@Service("articlePageTag")
public class ArticlePageTag extends BaseTag{
	@Autowired
	private ArticleService articleService;
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer folderId = Integer.parseInt(params.get("folderId").toString());
		Integer pages = Integer.parseInt(params.get("pages").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		
		try {
			PageVo<ArticleVo> pageVo = articleService.getArticlePageByFolderId(folderId, pages, rows);
			env.setVariable("tag_article_page", BEANS_WRAPPER.wrap(pageVo));
		} catch (FolderNotFoundException e) {
			env.setVariable("tag_article_page", BEANS_WRAPPER.wrap(null));
		}
		//渲染到视图模板
		body.render(env.getOut());
		
	}

}
