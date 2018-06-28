package service;

import com.addoiles.BaseService;
import com.addoiles.ManagerService;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   9/24/2017
 */
public interface ArticleService extends BaseService<Article>,ManagerService<Article> {
    /**
     * 获取文章列表
     * @apiNote 网站 (不和任何状态相关，保证页面显示10条数据)
     */
    List<Article> getArticleList(@Param("queryDto")QueryDto queryDto);

    /**
     * 根据用户id获取最新文章
     */
    List<Article> getLatestArticleByUserId(@Param("userId")String userId);
}
