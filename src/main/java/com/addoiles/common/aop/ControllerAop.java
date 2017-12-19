package com.addoiles.common.aop;


import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.exception.BusinessException;
import com.addoiles.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Controller 切面
 * Created by bla on 9/24/2017.
 */
@Aspect
@Component
public class ControllerAop {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Pointcut("execution(* controller.*.*(..)))")
    private void aspectJMethod() {
    }

    @Before("aspectJMethod()")
    public void before(JoinPoint joinPoint) {
        logger.info("method：{} , args:{}", joinPoint.getSignature().getName(), JsonUtils.toJson(joinPoint.getArgs()));
    }

    @Around("aspectJMethod()")
    public OilResponse around(ProceedingJoinPoint pjp) throws Throwable {
        OilResponse oilResponse = new OilResponse();

        try {
            Object proceed = pjp.proceed();
            oilResponse.setData(proceed);
            logger.info("method:{} ,response:{}", pjp.getSignature().getName(), JsonUtils.toJson(oilResponse));
        } catch (Exception exception) {
            if (exception instanceof BusinessException) {
                oilResponse.setCode(((BusinessException) exception).getCode());
                oilResponse.setMessage((exception).getMessage());
                logger.error("business error:{}", exception);
            } else {
                oilResponse.setErrorCode(ErrorCode.SYSTEM_ERROR);
                logger.error("system error:{}", exception);
            }

        }

        return oilResponse;
    }


}
