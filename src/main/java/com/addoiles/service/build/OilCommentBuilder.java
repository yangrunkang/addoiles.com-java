package com.addoiles.service.build;

import com.addoiles.common.enums.OilCommentConstant;
import com.addoiles.entity.OilComment;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/8/7 19:42
 */
public class OilCommentBuilder {

    public static void buildOilComment(OilComment oilComment){
        oilComment.setCommentId(OilUtils.generateID());
        oilComment.setCreateTime(TimeUtil.currentTime());
        oilComment.setDeleteStatus(OilCommentConstant.DeleteStatus.NORMAL.getValue());
    }

}
