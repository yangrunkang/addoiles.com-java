package com.addoiles.util;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.entity.Article;
import com.addoiles.exception.BusinessException;

import java.util.Objects;

/**
 * Description: 业务工具类
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/24 8:59
 */
public class BusinessUtils {

    /**
     * 检查文章是否存在或有效
     *
     * @param article
     * @param articleType
     */
    public static void isArticleExists(Article article, DBFieldEnum.ArticleType articleType) {
        if (Objects.isNull(article)
                || !article.getDeleteStatus().equals(DBFieldEnum.ArticleDeleteStatus.NORMAL.getValue())
                || !article.getIsHide().equals(DBFieldEnum.ArticleIsHide.NOT_HIDE.getValue())
                || !article.getArticleType().equals(articleType.getValue())) {
            throw new BusinessException(ErrorCode.ARTICLE_NOT_EXISTS);
        }
    }

}
