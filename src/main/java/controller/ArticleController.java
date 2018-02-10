package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.dto.req.RatesDto;
import com.addoiles.dto.resp.ExperienceDto;
import com.addoiles.dto.view.ITTechDto;
import com.addoiles.entity.*;
import com.addoiles.impl.ServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArticleService;
import service.CommentService;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.addoiles.common.enums.OilConstant.CONTENT_TOO_LONG;

/**
 * 文章
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   9/24/2017
 */
@Controller
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @Resource
    private OilRedisService oilRedisService;

    @RequestMapping(value = "getExperienceList", method = RequestMethod.POST)
    @ResponseBody
    public Object getExperienceList(@RequestBody QueryDto queryDto) {
        //use redis
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
        List<Article> articleList = articleService.getSimpleList(queryDto);


        if (CollectionUtils.isEmpty(articleList)) {
            //在页面上显示空
            return articleList;
        }

        articleList = doFilterArticleSimpleList(articleList);

        //处理userId转userName
        ServiceUtil.HandleArticleUserIdToUserName(articleList, usersOfIdNameList);

        return articleList;
    }

    @RequestMapping(value = "getExperience", method = RequestMethod.POST)
    @ResponseBody
    public Object getExperienceDto(@RequestBody QueryDto queryDto){
        ExperienceDto experienceDto = new ExperienceDto();

        //use redis
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
        Article article = articleService.getByBusinessId(queryDto.getBusinessId());


        if (Objects.isNull(article)) {
            //在页面上显示空
            return experienceDto;
        }

        //处理userId转userName
        ServiceUtil.HandleArticleUserIdToUserName(Collections.singletonList(article), usersOfIdNameList);
        List<Comment> commentList = commentService.getCommentListByTargetId(article.getArticleId());
        if (!CollectionUtils.isEmpty(commentList)) {
            experienceDto.setArticle(article);
            //处理userId转userName
            ServiceUtil.HandleCommentUserIdToUserName(commentList, usersOfIdNameList);
            experienceDto.setCommentList(commentList);
        } else {
            experienceDto.setArticle(article);
            experienceDto.setCommentList(new ArrayList<>());
        }
        //设定评分
        Integer rates = article.getRates();
        Integer rateCount = article.getRateCount();
        if (Objects.nonNull(rateCount) && rateCount > 0) {
            article.setRates(rates / rateCount > 5 ? 5 : rates / rateCount);
        }

        return experienceDto;
    }

    @RequestMapping(value = "getITArticleList",method = RequestMethod.POST)
    @ResponseBody
    public Object getITArticleList(@RequestBody QueryDto queryDto) {
        ITTechDto itTechDto = new ITTechDto();

        String businessId = queryDto.getBusinessId();
        Article article = articleService.getByBusinessId(businessId);

        List<Comment> articleCommentList = commentService.getCommentListByTargetId(article.getArticleId());
        if (CollectionUtils.isEmpty(articleCommentList)) {
            articleCommentList = new ArrayList<>();
        }
        //显示指定articleId对应的文章
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
        //处理评论 userId转userName
        ServiceUtil.HandleCommentUserIdToUserName(articleCommentList, usersOfIdNameList);
        //处理文章 userId转userName
        ServiceUtil.HandleArticleUserIdToUserName(Collections.singletonList(article), usersOfIdNameList);

        itTechDto.setArticle(article);
        itTechDto.setArticleCommentList(articleCommentList);

        return itTechDto;
    }

    @RequestMapping(value = "getITArticlePithinessList",method = RequestMethod.POST)
    @ResponseBody
    public Object getITArticlePithinessList(@RequestBody QueryDto queryDto) {
        List<Article> pithinessList = articleService.getSimpleList(queryDto);
        pithinessList = doFilterArticleSimpleList(pithinessList);
        return pithinessList;
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
        return doFilterArticleSimpleList(simpleList);
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

    @RequestMapping(value = "getFistPageImage", method = RequestMethod.POST)
    @ResponseBody
    public Object getRecommend() {
        List<Recommend> fistPageImage = oilRedisService.getRecommend();
        if(CollectionUtils.isEmpty(fistPageImage)){
            return new ArrayList<Recommend>();
        }
        return fistPageImage;
    }



    private List<Article> doFilterArticleSimpleList(List<Article> simpleList){
        simpleList = simpleList.stream()
                //过滤掉非草稿
                .filter(article -> article.getDeleteStatus() != DBFieldEnum.ArticleDeleteStatus.DRAFT.getValue())
                //过滤掉非隐藏的
                .filter(article -> article.getIsHide() != DBFieldEnum.ArticleIsHide.HIDE.getValue())
                .collect(Collectors.toList());
        return simpleList;
    }

}
