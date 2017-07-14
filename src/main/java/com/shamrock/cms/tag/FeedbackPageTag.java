package com.shamrock.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.constant.GuestbookConstant;
import com.shamrock.cms.vo.GuestbookVo;
import com.shamrock.cms.vo.PageVo;
import com.shamrock.cms.service.GuestbookService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service("feedbackPageTag")
public class FeedbackPageTag extends BaseTag {

	@Autowired
	private GuestbookService messageBoardService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer pages = Integer.parseInt(params.get("pages").toString());
		PageVo<GuestbookVo> pageVo = messageBoardService.getMessageBoardPage(pages,
				GuestbookConstant.Status.display, "number");
		env.setVariable("tag_feedback_page", BEANS_WRAPPER.wrap(pageVo));

		body.render(env.getOut());
	}
}
