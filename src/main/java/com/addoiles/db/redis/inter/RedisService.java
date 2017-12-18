package com.addoiles.db.redis.inter;

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

    void delete(String key);

    String get(String key);

    void set(String key,String value);

}
