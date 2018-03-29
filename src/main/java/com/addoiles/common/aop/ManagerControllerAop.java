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
import service.OilRedisService;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Description:用户管理界面请求 切面
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/3/29 10:24
 */
@Aspect
@Component
public class ManagerControllerAop {

    private static final Logger logger = LoggerFactory.getLogger(ManagerControllerAop.class);

    @Resource
    private OilRedisService oilRedisService;

    @Pointcut("execution(* controller.manager.*.*(..)))")
    private void aspectJMethod() {
    }

    @Before("aspectJMethod()")
    public void before(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            throw new Exception("must have one param at least!");
        }

        try {
            Object oneParam = joinPoint.getArgs()[0];
            Class<?> paramClass = oneParam.getClass();

            Field tokenIdField = paramClass.getDeclaredField("tokenId");
            tokenIdField.setAccessible(true);
            Object tokenId = tokenIdField.get(oneParam);

            Field userIdField = paramClass.getDeclaredField("userId");
            userIdField.setAccessible(true);
            Object userId = userIdField.get(oneParam);

            if(Objects.isNull(tokenId) || Objects.isNull(userId)){
                throw new BusinessException(ErrorCode.TOKEN_ID_USER_ID_NULL);
            }

            String userTokenId = oilRedisService.getUserTokenId(userId.toString());
            if(Objects.isNull(userTokenId) || !userTokenId.equals(tokenId)){
                throw new BusinessException(ErrorCode.ILLEGAL_REQUEST);
            }

            logger.info("method：{} , args:{}", joinPoint.getSignature().getName(), JsonUtils.toJson(joinPoint.getArgs()));
        } catch (BusinessException e){
            throw  e;
        } catch (Exception e){
            throw new Exception(ErrorCode.SYSTEM_ERROR.getMessage());
        }
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
                oilResponse.setCode(businessException.getCode());
                oilResponse.setMessage(businessException.getErrorMsg());
                logger.error("Manager Business Error:{}", JsonUtils.toJson(oilResponse));
            } else {
                oilResponse.setErrorCode(ErrorCode.SYSTEM_ERROR);
                oilResponse.setMessage(exception.getMessage());
                logger.error("Manager System Error:{}", exception);
            }
        }

        return oilResponse;
    }

}
