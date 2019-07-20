package com.addoiles.db.cache;

import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.sync.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description: 程序启动时缓存数据库所有文章
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/3 9:06
 */
@Component
public class OilCache implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private RedisService redisService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //删除redis key
        this.delRedisKeys();

        //缓存文章
//        OilEventBusHandle.getInstance().postEvent(new CacheArticleEvent());

        //缓存问题
//        OilEventBusHandle.getInstance().postEvent(new CacheQuestionEvent());

        //缓存导航栏
//        OilEventBusHandle.getInstance().postEvent(new CacheNavListEvent());

        //缓存首页图片
//        OilEventBusHandle.getInstance().postEvent(new CachePageImageEvent());

        //缓存梦想
//        OilEventBusHandle.getInstance().postEvent(new CacheDreamEvent());
    }

    /**
     * 清楚redis所有key
     */
    private void delRedisKeys() {
        redisService.deleteKeys(OilRedisConstant.OIL_WEBSITE + "*");
    }


}
