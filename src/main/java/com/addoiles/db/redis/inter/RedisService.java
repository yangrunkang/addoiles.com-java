package com.addoiles.db.redis.inter;

import java.util.Set;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/18 15:53
 */

public interface RedisService {

    /**
     * 根据key删除
     * @param key
     */
    void delete(String key);

    /**
     * 获取所有键
     * @param pattern
     * @return
     */
    Set<String> keys(String pattern);

    /**
     * 根据key获取
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置值
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 设置值 - 有效期
     * @param key
     * @param value
     * @param timeLong
     */
    void setTTL(String key,String value,Integer timeLong);

    /**
     * 删除符合 pattern 模式的key
     * @param pattern
     */
    void deleteKeys(String pattern);

}
