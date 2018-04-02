package controller.manager;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.view.SimpleListDto;
import com.addoiles.entity.Article;
import controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArticleService;
import service.MicroContentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:查询操作
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/3/23 9:28
 */
@Controller
public class GetController extends BaseController {

    @Resource
    private MicroContentService microContentService;

    @Resource
    private ArticleService articleService;

    /**
     * 获取短内容
     * @param queryDto
     * @return
     */
    @RequestMapping(value = "getMicroContentList", method = RequestMethod.POST)
    @ResponseBody
    public Object getMicroContentList(@RequestBody QueryDto queryDto) {
        return microContentService.getList(queryDto);
    }

    /**
     * 根据businessId获取文章
     *
     * @apiNote 编辑器使用
     * @apiNote 用户管理中心使用
     *
     * @param queryDto
     * @return
     */
    @RequestMapping(value = "getArticleByBusinessId",method = RequestMethod.POST)
    @ResponseBody
    public Object getArticleByBusinessId(@RequestBody QueryDto queryDto) {
        return articleService.getByBusinessId(queryDto.getBusinessId());
    }


    @RequestMapping(value = "getSimpleList",method = RequestMethod.POST)
    @ResponseBody
    public Object getSimpleList(@RequestBody QueryDto queryDto) {
        SimpleListDto simpleListDto = new SimpleListDto();

        List<Article> articleList = articleService.getSimpleList(queryDto);
        Integer totalCount = articleService.getTotalCount(queryDto);

        simpleListDto.setArticleList(articleList);
        simpleListDto.setTotalCount(totalCount);

        return simpleListDto;
    }



}
