package com.addoiles.common.aop;


import com.addoiles.common.ErrorCode;
import com.addoiles.common.OilResponse;
import com.addoiles.common.enums.OilConstant;
import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.exception.BusinessException;
import com.addoiles.mail.dto.Email;
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
 * 网站请求Controller 切面
 * 主要记录入参出餐
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
        } catch (Exception exception) {
            if (exception instanceof BusinessException) {
                BusinessException businessException = (BusinessException) exception;
                oilResponse.setCode((businessException.getCode()));
                oilResponse.setMessage(businessException.getErrorMsg());
                logger.error("Addoiles Website Business Error:{}", JsonUtils.toJson(oilResponse));
            } else {
                oilResponse.setErrorCode(ErrorCode.SYSTEM_ERROR);
                logger.error("Addoiles Website System Error:{}", exception);
            }
            //异步异常通知
            Email email = new Email();
            email.setSubject("ControllerAop");
            email.setContent(exception.getMessage());
            email.setReceiver(OilConstant.getHostReceiver());
            OilEventBusHandle.getInstance().postEvent(email);
        }

        return oilResponse;
    }


}
