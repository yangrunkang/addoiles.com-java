package com.addoiles.sync;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.google.common.eventbus.Subscribe;

import javax.annotation.Resource;

/**
 * 邮件监听器
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2018/4/20 14:57
 */
@OilEventListener
public class BusinessEmailListener {

    @Resource
    private EmailService emailService;

    @Subscribe
    public void sendBusinessEmail(Email email){
        emailService.sendBusinessEmail(email);
    }

}
