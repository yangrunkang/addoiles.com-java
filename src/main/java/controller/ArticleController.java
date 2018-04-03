package controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.resp.ExperienceDto;
import com.addoiles.dto.view.ITTechDto;
import com.addoiles.entity.Article;
import com.addoiles.entity.Comment;
import com.addoiles.entity.Recommend;
import com.addoiles.entity.User;
import com.addoiles.exception.BusinessException;
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

    @RequestMapping(value = "experienceList", method = RequestMethod.POST)
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

    @RequestMapping(value = "experience", method = RequestMethod.POST)
    @ResponseBody
    public Object getExperienceDto(@RequestBody QueryDto queryDto){
        ExperienceDto experienceDto = new ExperienceDto();

        Article article = articleService.getByBusinessId(queryDto.getBusinessId());

        if (Objects.isNull(article)
                || !article.getDeleteStatus().equals(DBFieldEnum.ArticleDeleteStatus.NORMAL.getValue())) {
            return new BusinessException(ErrorCode.EXPERIENCE_NOT_EXISTS);
        }

        //use redis
        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
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

    @RequestMapping(value = "ITArticle",method = RequestMethod.POST)
    @ResponseBody
    public Object getITArticleList(@RequestBody QueryDto queryDto) {
        ITTechDto itTechDto = new ITTechDto();

        String businessId = queryDto.getBusinessId();
        Article article = articleService.getByBusinessId(businessId);

        if (Objects.isNull(article)
                || !article.getDeleteStatus().equals(DBFieldEnum.ArticleDeleteStatus.NORMAL.getValue())) {
            return new BusinessException(ErrorCode.IT_ARTICLE_NOT_EXISTS);
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
        ServiceUtil.HandleArticleUserIdToUserName(Collections.singletonList(article), usersOfIdNameList);

        itTechDto.setArticle(article);
        itTechDto.setArticleCommentList(articleCommentList);

        return itTechDto;
    }

    @RequestMapping(value = "ITPithinessList",method = RequestMethod.POST)
    @ResponseBody
    public Object getITArticlePithinessList(@RequestBody QueryDto queryDto) {
        List<Article> pithinessList = articleService.getSimpleList(queryDto);
        pithinessList = doFilterArticleSimpleList(pithinessList);
        return pithinessList;
    }

    /**
     * 展示更多
     *
     * @return
     */
    @RequestMapping("moreArticles")
    @ResponseBody
    public Object showMoreITTechArticles(@RequestBody QueryDto queryDto) {
        List<Article> simpleList = articleService.getSimpleList(queryDto);
        return doFilterArticleSimpleList(simpleList);
    }

    @RequestMapping(value = "recommendList", method = RequestMethod.POST)
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
