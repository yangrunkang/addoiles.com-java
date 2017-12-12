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
     *
     * @return
     */
    public static String generateID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成随机数
     *
     * @param length 生成的随机数长度
     * @return
     */
    public static String generateRandom(int length) {
        return String.valueOf(Math.random()).substring(2, length + 2);
    }

}
