package com.addoiles.service.build;

import com.addoiles.common.enums.OilArticleConstant;
import com.addoiles.entity.OilArticle;
import com.addoiles.util.TimeUtil;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:22
 */
public class OilArticleBuilder {


    /**
     * 默认文章
     * @param oilArticle
     * @return
     */
    public static void buildDefaultOilArticle(OilArticle oilArticle){
        oilArticle.setCreateTime(TimeUtil.currentTime());
        oilArticle.setDeleteStatus(OilArticleConstant.DeleteStatus.NORMAL.getValue());
        oilArticle.setType(OilArticleConstant.Type.DREAM.getValue());
    }


}
