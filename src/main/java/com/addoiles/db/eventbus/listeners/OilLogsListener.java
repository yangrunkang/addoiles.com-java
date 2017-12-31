package com.addoiles.db.eventbus.listeners;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.db.eventbus.event.AddArticleEvent;
import com.google.common.eventbus.Subscribe;

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

    @Subscribe
    public void addArticle(AddArticleEvent addArticleEvent){
        System.out.println("添加了文章");
    }

}
