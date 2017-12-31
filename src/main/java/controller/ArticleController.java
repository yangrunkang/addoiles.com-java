package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.dto.req.RatesDto;
import com.addoiles.dto.resp.ExperienceDto;
import com.addoiles.dto.view.ITTechDto;
import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;
import com.addoiles.entity.User;
import com.addoiles.impl.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArticleService;
import service.CommentService;
import service.OilRedisService;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.addoiles.common.enums.OilConstant.CONTENT_TOO_LONG;

/**
 *
 * Created by bla on 9/24/2017.
 */
@Controller
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Resource
    private OilRedisService oilRedisService;


    @RequestMapping(value = "getExperienceList", method = RequestMethod.POST)
    @ResponseBody
    public Object getExperienceList(@RequestBody QueryDto queryDto) {
        List<ExperienceDto> articleDtoList = new ArrayList<>();

        //use redis
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
        List<Article> articleList = articleService.getList(queryDto);


        if (CollectionUtils.isEmpty(articleList)) {
            //在页面上显示空
            return articleDtoList;
        } else {
            //处理userId转userName
            ServiceUtil.HandleArticleUserIdToUserName(articleList, usersOfIdNameList);
            articleList.forEach(article -> {
                List<Comment> commentList = commentService.getCommentListByTargetId(article.getArticleId());
                if (!CollectionUtils.isEmpty(commentList)) {
                    ExperienceDto articleDto = new ExperienceDto();
                    articleDto.setArticle(article);
                    //处理userId转userName
                    ServiceUtil.HandleCommentUserIdToUserName(commentList, usersOfIdNameList);
                    articleDto.setCommentList(commentList);
                    articleDtoList.add(articleDto);
                } else {
                    ExperienceDto articleDto = new ExperienceDto();
                    articleDto.setArticle(article);
                    articleDto.setCommentList(new ArrayList<>());
                    articleDtoList.add(articleDto);
                }
                //设定评分
                Integer rates = article.getRates();
                Integer rateCount = article.getRateCount();
                if (rateCount > 0) {
                    article.setRates(rates / rateCount > 5 ? 5 : rates / rateCount);
                }

            });
        }
        return articleDtoList;
    }



    @RequestMapping(value = "getITArticleList",method = RequestMethod.POST)
    @ResponseBody
    public Object getITArticleList(@RequestBody QueryDto queryDto) {
        ITTechDto itTechDto = new ITTechDto();
        List<Article> pithinessArticleList = articleService.getSimpleList(queryDto);

        if(CollectionUtils.isEmpty(pithinessArticleList)){
            return  itTechDto;
        }

        pithinessArticleList =doFilterITTechList(pithinessArticleList);

        Article article;
        String businessId = queryDto.getBusinessId();

        if (Objects.nonNull(businessId)) {
            article = articleService.getByBusinessId(businessId);
        } else {
            //显示默认第一篇文章
            article = articleService.getByBusinessId(pithinessArticleList.get(0).getArticleId());
        }
        List<Comment> articleCommentList = commentService.getCommentListByTargetId(article.getArticleId());
        if (CollectionUtils.isEmpty(articleCommentList)) {
            articleCommentList = new ArrayList<>();
        }
        //显示指定articleId对应的文章
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
        //处理评论 userId转userName
        ServiceUtil.HandleCommentUserIdToUserName(articleCommentList, usersOfIdNameList);
        //处理文章 userId转userName
        ServiceUtil.HandleArticleUserIdToUserName(Arrays.asList(article), usersOfIdNameList);

        itTechDto.setPithinessList(pithinessArticleList);
        itTechDto.setArticle(article);
        itTechDto.setArticleCommentList(articleCommentList);

        return itTechDto;
    }


    @RequestMapping(value = "getSimpleList",method = RequestMethod.POST)
    @ResponseBody
    public Object getSimpleList(@RequestBody QueryDto queryDto) {
        return articleService.getSimpleList(queryDto);
    }


    /**
     * 根据businessId获取文章
     * @apiNote 编辑器使用
     * @param queryDto
     * @return
     */
    @RequestMapping(value = "getArticleByBusinessId",method = RequestMethod.POST)
    @ResponseBody
    public Object getArticleByBusinessId(@RequestBody QueryDto queryDto) {
        return articleService.getByBusinessId(queryDto.getBusinessId());
    }



    /**
     * 展示更多
     *
     * @return
     */
    @RequestMapping("showMoreITTechArticles")
    @ResponseBody
    public Object showMoreITTechArticles(@RequestBody QueryDto queryDto) {
        List<Article> simpleList = articleService.getSimpleList(queryDto);
        return doFilterITTechList(simpleList);
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

    @RequestMapping(value = "deleteArticle", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestBody QueryDto queryDto) {
        return articleService.delete(queryDto.getBusinessId());
    }

    @RequestMapping(value = "getArticlesByArticleId", method = RequestMethod.GET)
    @ResponseBody
    public Object getArticlesByArticleId(String articleId) {
        return articleService.getByBusinessId(articleId);
    }

    @RequestMapping(value = "updateRates", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRates(@RequestBody RatesDto ratesDto) {
        Article tmp = new Article();
        tmp.setArticleId(ratesDto.getBusinessId());
        tmp.setRates(ratesDto.getRate());
        return articleService.update(tmp);
    }

    private List<Article> doFilterITTechList(List<Article> simpleList){
        simpleList = simpleList.stream()
                //过滤掉非草稿
                .filter(article -> article.getDeleteStatus() != DBFieldEnum.ArticleDeleteStatus.DRAFT.getValue())
                //过滤掉非隐藏的
                .filter(article -> article.getIsHide() != DBFieldEnum.ArticleIsHide.HIDE.getValue())
                .collect(Collectors.toList());
        return simpleList;
    }

}
