package com.shamrock.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.service.ConfigService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author GunnyZeng file标签
 */
@Service("configTag")
public class ConfigTag extends BaseTag {

	@Autowired
	private ConfigService configService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		String key = params.get("key").toString();
		String value = configService.getStringByKey(key);
		env.setVariable("tag_value", BEANS_WRAPPER.wrap(value));
		body.render(env.getOut());
	}
}
