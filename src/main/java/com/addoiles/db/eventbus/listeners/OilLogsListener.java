package com.addoiles.db.eventbus.listeners;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.db.eventbus.event.AddArticleEvent;
import com.addoiles.db.eventbus.event.ReCacheDreamsEvent;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.OilRedisService;

import javax.annotation.Resource;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/19 17:10
 */
@OilEventListener
public class OilLogsListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OilLogsListener.class);

    @Resource
    private OilRedisService oilRedisService;

    @Subscribe
    public void addArticle(AddArticleEvent addArticleEvent){
        System.out.println("添加了文章");
    }

    @Subscribe
    public void addArticle(ReCacheDreamsEvent reCacheDreamsEvent){
        oilRedisService.getAllDreams();
        LOGGER.info("reCached Dreams");
    }



}
