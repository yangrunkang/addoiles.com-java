package com.addoiles.dao;

import com.addoiles.entity.OilText;
import org.apache.ibatis.annotations.Param;

public interface OilTextMapper {

    OilText selectByArticleId(@Param("articleId")String articleId);

    Integer insert(OilText oilText);

}