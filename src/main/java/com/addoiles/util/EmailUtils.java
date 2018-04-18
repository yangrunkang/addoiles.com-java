package com.addoiles.util;

import com.addoiles.common.enums.OilConstant;
import com.addoiles.db.eventbus.OilEventBusHandle;
import com.addoiles.exception.BusinessException;
import com.addoiles.mail.dto.Email;

import java.util.Date;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/18 14:00
 */
public class EmailUtils {

    /**
     * 业务异常邮件
     * @param e
     */
    public static void businessExceptionEmail(Exception e){
        Email email = new Email();
        email.setSubject("BusinessExceptionEmail");
        if(e instanceof BusinessException){
            email.setContent(new Date() + ((BusinessException) e).getErrorMsg());
        }else{
            email.setContent(JsonUtils.toJson(e));
        }
        email.setReceiver(OilConstant.getHostReceiver());
        OilEventBusHandle.getInstance().postEvent(email);
    }

    /**
     * 业务提醒邮件
     */
    public static void businessNotifyEmail(String subject,String content){
        Email email = new Email();
        email.setSubject(subject);
        email.setContent(content);
        email.setReceiver(OilConstant.getHostReceiver());
        OilEventBusHandle.getInstance().postEvent(email);
    }



}
