package com.addoiles.service;

import com.addoiles.entity.OilText;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface OilTextService {

    OilText selectByArticleId(@Param("articleId")String articleId);

    Integer insert(OilText oilText);

}
