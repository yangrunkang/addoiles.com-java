package service;

import com.addoiles.common.Page;
import com.addoiles.entity.Article;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface ArticleService {

    /**
     * 获取IT技术文章列表
     *
     * @param page
     * @return
     */
    List<Article> getITTechArticleList(Page page);

    /**
     * 获取IT技术文章
     *
     * @param articleId   文章id
     * @param articleType 文章类型 1-软件评测 2-技术沉淀 3-提问
     */
    Article getArticleByParams(String articleId, Integer articleType);


    List<Article> getArticleByArticleType(Page page, Integer articleType);


    /**
     * 查询简洁的文章
     * 只查询文章id,文章标题,副标题
     *
     * @param page        分页对象
     * @param articleType 文章类型 1-软件评测 2-技术沉淀
     * @return
     */
    List<Article> selectPithinessByType(Page page, Integer articleType);

    /**
     * 获取软件评测文章
     */
    List<Article> getSoftwareTalkArticleList(Page page);

    /**
     * 添加文章
     */
    Integer addArticle(Article article);

    /**
     * 编辑文章
     */
    Integer editArticle(Article article);

    /**
     * 获取用户文章
     *
     * @param userId
     * @return
     */
    List<Article> getArticlesByUserId(String userId, String articleType);

    /**
     * 根据articleId获取文章
     * @param articleId
     * @return
     */
    Article getArticlesByArticleId(String articleId);

    /**
     * 根据文章id删除
     *
     * @param articleId
     * @return
     */
    Integer deleteByArticleId(String articleId);

}
