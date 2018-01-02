package com.addoiles.common.aop;

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
public class OilRedisAop {

    private static final Logger logger = LoggerFactory.getLogger(OilRedisAop.class);

    @Pointcut("@annotation(com.addoiles.common.annotations.OilRedis)")
    private void aspectJMethod() {
    }

    @Before("aspectJMethod()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("method：{} , args:{}", methodName, JsonUtils.toJson(joinPoint.getArgs()));


    }

}
