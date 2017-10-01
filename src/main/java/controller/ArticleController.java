package controller;

import com.addoiles.common.Page;
import com.addoiles.dto.ITTechDto;
import com.addoiles.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArticleService;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class ArticleController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @RequestMapping("getITTechArticleList")
    @ResponseBody
    public Object getITTechArticleList(Page page){
        ITTechDto itTechDto = new ITTechDto();
        List<Article> articles = articleService.selectPithinessByType(page, 2);
//        articleService.


        return itTechDto;
    }

    @RequestMapping("getSoftwareTalkArticleList")
    @ResponseBody
    public Object getSoftwareTalkArticleList(Page page){
        return articleService.getSoftwareTalkArticleList(page);
    }

}
