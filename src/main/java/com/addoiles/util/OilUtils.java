package com.addoiles.util;

import java.util.UUID;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:15
 */
public class OilUtils {

    /**
     * 生成ID
     * @return
     */
    public static String generateID(){
        return UUID.randomUUID().toString().replace("-","");
    }



}
