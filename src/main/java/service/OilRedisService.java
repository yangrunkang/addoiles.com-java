package service;

import com.addoiles.entity.*;

import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 16:53
 */

public interface OilRedisService {

    /**
     * 获取所有用户Id-Name集合
     * @param reload 是否重载
     * @return
     */
    List<User> getUsersIdsNames(Boolean reload);


    /**
     * 缓存用户验证码
     * @param email
     * @param code
     * @return
     */
    void cacheUserVerifyCode(String email,String code);

    /**
     * 根据邮箱获取验证码
     * @param email
     * @return
     */
    String getVerifyCodeByEmail(String email);

    /**
     * 获取导航栏
     * @return
     */
    List<NavSettings> getNavList();

    /**
     * 根据文章id获取文章
     * @param articleId
     * @return
     */
    Article getArticleByArticleId(String articleId);

    /**
     * 根据文章id删除文章
     * @param articleId
     */
    void deleteArticleByArticleId(String articleId);

    /**
     * 添加文章
     * @param article
     */
    void addArticle(Article article);

    /**
     * 更新文章
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 获取首页图片
     * @return
     */
    List<Recommend> getRecommend();

    /**
     * 获取所有梦想
     * @return
     */
    List<MicroContent> getAllDreams();
}
