package com.addoiles.common.aop;

import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.dto.event.TestEvent;
import com.addoiles.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        logger.info("method：{} , args:{}", joinPoint.getSignature().getName(), JsonUtils.toJson(joinPoint.getArgs()));
        TestEvent testEvent = new TestEvent();
        OilEventBusHandle.getInstance().postEvent(testEvent);
    }




}
