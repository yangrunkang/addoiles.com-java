package controller;

import com.addoiles.common.Page;
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

    @RequestMapping("getITTechArticleList")
    @ResponseBody
    public Object getITTechArticleList(Page page, String articleId) {
        ITTechDto itTechDto = new ITTechDto();
        List<Article> pithinessArticleList = articleService.selectPithinessByType(page, 2);
        if (!CollectionUtils.isEmpty(pithinessArticleList)) {
            Article firstInList = pithinessArticleList.get(0);
            Article article;
            if (Objects.nonNull(articleId)) { //显示指定articleId对应的文章
                article = articleService.getArticleByParams(articleId, 2);
            } else { //显示默认第一篇文章
                article = articleService.getArticleByParams(firstInList.getArticleId(), 2);
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
     * @param page
     * @return
     */
    @RequestMapping("showMoreITTechArticles")
    @ResponseBody
    public Object showMoreITTechArticles(@RequestBody Page page) {
        return articleService.selectPithinessByType(page, 2);
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
    public Object getArticlesByUserId(String userId) {
        Quer
        return articleService.getByUserId(userId);
    }

    @RequestMapping(value = "deleteByArticleId", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteByArticleId(String articleId) {
        return articleService.deleteByArticleId(articleId);
    }

    @RequestMapping(value = "getArticlesByArticleId", method = RequestMethod.GET)
    @ResponseBody
    public Object getArticlesByArticleId(String articleId) {
        return articleService.getArticlesByArticleId(articleId);
    }


}
