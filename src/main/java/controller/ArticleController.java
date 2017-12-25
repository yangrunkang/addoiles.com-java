package controller;

import com.addoiles.dto.query.QueryDto;
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
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.addoiles.common.enums.OilConstant.CONTENT_TOO_LONG;

/**
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

    @RequestMapping(value = "getITTechArticleList",method = RequestMethod.POST)
    @ResponseBody
    public Object getITTechArticleList(@RequestBody QueryDto queryDto) {
        ITTechDto itTechDto = new ITTechDto();
        List<Article> pithinessArticleList = articleService.selectPithinessByType(queryDto);
        if (!CollectionUtils.isEmpty(pithinessArticleList)) {
            Article article;
            String businessId = queryDto.getBusinessId();
            if (Objects.nonNull(businessId)) { //显示指定articleId对应的文章
                article = articleService.getByBusinessId(businessId);
            } else { //显示默认第一篇文章
                article = pithinessArticleList.get(0);
            }
            List<Comment> articleCommentList = commentService.getCommentListByTargetId(article.getArticleId());
            if (CollectionUtils.isEmpty(articleCommentList)) {
                articleCommentList = new ArrayList<>();
            }
            //处理userId转userName
            List<User> usersOfIdNameList = userService.getUsersOfIdNameList();
            ServiceUtil.HandleCommentUserIdToUserName(articleCommentList, usersOfIdNameList);

            itTechDto.setPithinessList(pithinessArticleList);
            itTechDto.setArticle(article);
            itTechDto.setArticleCommentList(articleCommentList);
        }
        return itTechDto;
    }

    /**
     * 展示更多
     *
     * @return
     */
    @RequestMapping("showMoreITTechArticles")
    @ResponseBody
    public Object showMoreITTechArticles(@RequestBody QueryDto queryDto) {
        return articleService.selectPithinessByType(queryDto);
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


    @RequestMapping("getArticlesByUserId")
    @ResponseBody
    public Object getArticlesByUserId(QueryDto queryDto) {
        return articleService.getList(queryDto);
    }

    @RequestMapping(value = "deleteByArticleId", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteByArticleId(String articleId) {
        return articleService.delete(articleId);
    }

    @RequestMapping(value = "getArticlesByArticleId", method = RequestMethod.GET)
    @ResponseBody
    public Object getArticlesByArticleId(String articleId) {
        return articleService.getByBusinessId(articleId);
    }


}
