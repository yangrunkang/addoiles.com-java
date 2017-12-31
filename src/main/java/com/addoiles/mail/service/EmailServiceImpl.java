package com.addoiles.mail.service;

import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 16:17
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private BaseEmailService baseEmailService;

    @Override
    public Boolean sendEmail(Email email) {
        try {
            baseEmailService.sendEmail(email);
        } catch (Exception e) {

            return false;
        }
        return true;
    }

}
