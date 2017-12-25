package service;

import com.addoiles.BaseService;
import com.addoiles.common.Page;
import com.addoiles.entity.Article;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface ArticleService extends BaseService<Article> {


    /**
     * 查询简洁的文章
     * 只查询文章id,文章标题,副标题
     *
     * @param page        分页对象
     * @param articleType 文章类型 1-软件评测 2-技术沉淀
     * @return
     */
    List<Article> selectPithinessByType(Page page, Integer articleType);

}
