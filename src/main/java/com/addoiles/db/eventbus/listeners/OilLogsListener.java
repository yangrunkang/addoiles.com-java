package com.addoiles.db.eventbus.listeners;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.dto.event.TestEvent;
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
    public void testEvent(TestEvent testEvent){
        System.out.println(testEvent.hi);
    }
}
