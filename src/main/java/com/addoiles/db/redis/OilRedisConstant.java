package com.addoiles.db.redis;

/**
 * Description: 油站Redis常量
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 16:59
 */

public class OilRedisConstant {

    /**
     * 开发时加上 DEV.
     * 生产是 DEV. 加上 PRD.
     */
    private static final String REDIS_ENV = "DEV.";

    /**
     * 缓存完整内容KEY标志
     */
//    private static final String TOTAL = "TOTAL.";

    /**
     * redis key 前缀
     */
    public static String OIL_WEBSITE = REDIS_ENV +"com.addoiles.wwww.";

    /**
     * 用户ID-用户名 映射集合
     */
    public static String USERS_ID_NAME_LIST = OIL_WEBSITE + "users.ids.names.list";

    /**
     * 导航栏
     */
    public static String NAV_LIST = OIL_WEBSITE + "nav.list";

}
