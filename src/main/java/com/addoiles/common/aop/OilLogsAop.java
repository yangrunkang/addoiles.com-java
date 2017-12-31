package com.addoiles.common.aop;

import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.db.eventbus.event.AddArticleEvent;
import com.addoiles.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description: 日志记录 切service层
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/19 16:21
 */
@Aspect
@Component
public class OilLogsAop {

    private static final Logger logger = LoggerFactory.getLogger(OilLogsAop.class);

    @Pointcut("@annotation(com.addoiles.common.annotations.OilLog)")
    private void aspectJMethod() {
    }

    @Before("aspectJMethod()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("method：{} , args:{}", methodName, JsonUtils.toJson(joinPoint.getArgs()));

        //post event
        Arrays.asList(EnumMethodEvent.values()).forEach(enumMethodEvent -> {
            if(enumMethodEvent.getMethodName().equals(methodName)){
                //todo 如何拿到数据,难道每次if --> set ???
                OilEventBusHandle.getInstance().postEvent(enumMethodEvent.getEvent());
            }
        });

    }



    /**
     * 方法对应的Event对象
     */
    private enum EnumMethodEvent{

        ADD_ARTICLE("addArticle", new AddArticleEvent(),"添加文章666"),
        ;
        private String methodName;
        private Object event;
        private String desc;


        EnumMethodEvent(String methodName, Object event, String desc) {
            this.methodName = methodName;
            this.event = event;
            this.desc = desc;
        }

        public String getMethodName() {
            return methodName;
        }

        public Object getEvent() {
            return event;
        }

        public String getDesc() {
            return desc;
        }
    }


}
