package com.addoiles.sync;

import com.addoiles.common.annotations.OilEventListener;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.google.common.eventbus.Subscribe;

import javax.annotation.Resource;

@OilEventListener
public class BusinessEmailSync {

    @Resource
    private EmailService emailService;

    @Subscribe
    public void sendBusinessEmail(Email email){
        emailService.sendBusinessEmail(email);
    }

}
