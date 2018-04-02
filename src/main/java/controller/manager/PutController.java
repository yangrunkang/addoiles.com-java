package controller.manager;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.req.RatesDto;
import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;
import com.addoiles.entity.Question;
import com.addoiles.entity.Suggest;
import controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;

import javax.annotation.Resource;

/**
 * Description: 增删改操作
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/2 19:16
 */
@Controller
public class PutController extends BaseController{

    @Resource
    private MicroContentService microContentService;

    @Resource
    private ArticleService articleService;

    @Resource
    private QuestionService questionService;

    @Resource
    private OilRedisService oilRedisService;

    /**
     * 删除短内容
     * @param queryDto
     * @return
     */
    @RequestMapping(value = "deleteMicroContent", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteMicroContent(@RequestBody QueryDto queryDto) {
        return microContentService.delete(queryDto.getBusinessId());
    }


    @RequestMapping(value = "updateRates", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRates(@RequestBody RatesDto ratesDto) {

        Article redisArticle = oilRedisService.getArticleByArticleId(ratesDto.getBusinessId());

        Article tmp = new Article();
        tmp.setArticleId(ratesDto.getBusinessId());
        tmp.setRates(ratesDto.getRate() + redisArticle.getRates());
        tmp.setRateCount(redisArticle.getRateCount() + 1);

        redisArticle.setRates(tmp.getRates());
        redisArticle.setRateCount(tmp.getRateCount());

        oilRedisService.updateArticle(redisArticle);

        return articleService.update(tmp);
    }

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    @ResponseBody
    public Object addComment(@RequestBody Comment comment) {
        return commentService.insert(comment);
    }

    @RequestMapping(value = "deleteByQuestionId", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteByQuestionId(@RequestBody QueryDto queryDto) {
        return questionService.delete(queryDto.getBusinessId());
    }
    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Object addQuestion(@RequestBody Question question) {
        return questionService.insert(question);
    }


    @Resource
    private SuggestService suggestService;


    @RequestMapping(value = "suggest", method = RequestMethod.POST)
    @ResponseBody
    public Object suggest(@RequestBody Suggest suggest) {
        suggestService.insert(suggest);
        return 0;
    }
}
