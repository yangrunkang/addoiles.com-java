package com.shamrock.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamrock.cms.constant.FolderConstant;
import com.shamrock.cms.entity.Folder;
import com.shamrock.cms.vo.FolderVo;
import com.shamrock.cms.exception.FolderNotFoundException;
import com.shamrock.cms.service.FolderService;

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
@Service("folderListTag")
public class FolderListTag extends BaseTag {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		long folderId = 0;
		List<FolderVo> list = new ArrayList<FolderVo>();
		// 获取页面的参数
		try {
			if (params.get("ename") == null) {
				folderId = Long.parseLong(params.get("folderId").toString());
			} else {
				String ename = params.get("ename").toString();
				Folder folder = folderService.getFolderByEname(ename);
				folderId = folder.getFolderId();
			}
			list = folderService.getFolderListByFatherId(folderId,
					FolderConstant.Status.display);
		} catch (FolderNotFoundException e) {
			// 丢弃
		}
		env.setVariable("tag_folder_list", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());
	}

}
