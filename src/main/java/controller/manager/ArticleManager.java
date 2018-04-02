package controller.manager;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Article;
import controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArticleService;

import javax.annotation.Resource;

import static com.addoiles.common.enums.OilConstant.CONTENT_TOO_LONG;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/2 19:26
 */
@Controller
public class ArticleManager extends BaseController{

    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "deleteArticle", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteArticle(@RequestBody QueryDto queryDto) {
        return articleService.delete(queryDto.getBusinessId());
    }

    @RequestMapping("addArticle")
    @ResponseBody
    public Object addArticle(@RequestBody Article article) {
        Integer count;
        try {
            count = articleService.insert(article);
        } catch (Exception e) {
            count = CONTENT_TOO_LONG;
        }
        return count;
    }

    @RequestMapping("editArticle")
    @ResponseBody
    public Object editArticle(@RequestBody Article article) {
        Integer count;
        try {
            count = articleService.update(article);
        } catch (Exception e) {
            count = CONTENT_TOO_LONG;
        }
        return count;
    }

}
