package com.addoiles.db.cache;

import com.addoiles.util.JsonUtils;
import com.addoiles.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Description: Java 实现缓存
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 14:07
 */
@Deprecated
public class CacheManager {

    private static final Logger logger = LoggerFactory.getLogger(CacheManager.class);

    /**
     * 缓存管理Map
     */
    private static Map<String, Cache> cacheMap = new HashMap<>();

    /**
     * 缓存管理器
     */
    private static CacheManager cacheManager;

    private CacheManager() {
        super();
    }

    /**
     * 获取缓存管理器实例
     *
     * @return 缓存管理器
     */
    public static CacheManager getInstance() {
        if (null == cacheManager) {
            cacheManager = new CacheManager();
        }
        return cacheManager;
    }

    private static Map<String, Cache> getCacheMap() {
        return getInstance().cacheMap;
    }


    /**
     * 设置缓存
     *
     * @param key         键值
     * @param object      缓存目标
     * @param expiredTime 过期时间
     */
    public void setString(String key, String object, Integer expiredTime) {
        Cache cache = new Cache(object, expiredTime, TimeUtil.currentTime());
        logger.info("add cache:key:{},cache:{}", key, JsonUtils.toJson(cache));
        getCacheMap().put(key, cache);
    }


    /**
     * 根据建获取String值
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return (String) getCacheMap().get(key).getValue();
    }

    /**
     * 清楚过期缓存
     */
    public void clearExpiredCache() {
        Set<Map.Entry<String, Cache>> entries = getCacheMap().entrySet();
        Iterator<Map.Entry<String, Cache>> iterator = entries.iterator();
        iterator.forEachRemaining(cacheEntry -> {
            //是否过期
            if (TimeUtil.currentTime() - cacheEntry.getValue().getCreatedTime() > cacheEntry.getValue().getExpireTime()) {
                logger.info("remove cache:key:{},cache:{}", cacheEntry.getKey(), JsonUtils.toJson(cacheEntry.getValue()));
                iterator.remove();
            }
        });
    }

    /**
     * 定时清楚缓存任务
     */
    public void clearTask() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
//                logger.info("clearTask begin run...{}", new Date());
                clearExpiredCache();
//                logger.info("clearTask run over...{},current cache pool size:{}", new Date(), getCacheMap().size());
            }
        };

        Timer timer = new Timer();
        //单位毫秒
        timer.scheduleAtFixedRate(timerTask, 5 * 1000, 10 * 1000);
    }

    /**
     * 缓存是否失效
     *
     * @param key
     * @return
     */
    public static Cache isExists(String key) {

        if (Objects.isNull(key)) {
            return null;
        }

        Set<Map.Entry<String, Cache>> entries = getCacheMap().entrySet();
        Iterator<Map.Entry<String, Cache>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cache> next = iterator.next();
            if (next.getKey().equals(key)) {
                return next.getValue();
            }
        }

        return null;
    }

    public static void remove(String key) {
        logger.info("CacheManager remove cache:key:{}", key);
        getCacheMap().remove(key);
    }

}
 
 
