package com.addoiles.service.build;

import com.addoiles.common.enums.OilUserConstant;
import com.addoiles.entity.OilUser;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:22
 */
public class OilUserBuilder {


    /**
     * 默认用户属性
     * @param oilUser
     * @return
     */
    public static OilUser buildDefaultOilUser(OilUser oilUser){
        oilUser.setUserId(OilUtils.generateID());
        oilUser.setCreateTime(TimeUtil.currentTime());
        oilUser.setDeleteStatus(OilUserConstant.NORMAL.getValue());
        return oilUser;
    }


}
