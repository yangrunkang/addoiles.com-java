package com.addoiles.db.eventbus;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.util.SpringContextUtils;
import com.google.common.eventbus.EventBus;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/19 16:58
 */

public class OilEventBusHandle {

    private static class OilEventBusHolder{
        private static final OilEventBusHandle INSTANCE = new OilEventBusHandle();
    }

    private static final String OIL_IDENTIFIER = "OIL";

    private EventBus eventBus;

    private OilEventBusHandle() {
        eventBus = new EventBus(OIL_IDENTIFIER);

        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(OilEventListener.class);

        beans.values().forEach(bean ->
                //待蓄状态
                eventBus.register(bean)
        );
    }

    public static OilEventBusHandle getInstance(){
        return OilEventBusHolder.INSTANCE;
    }

    /**
     * 提交事件
     * @param event
     */
    public void postEvent(Object event){
        eventBus.post(event);
    }
}
