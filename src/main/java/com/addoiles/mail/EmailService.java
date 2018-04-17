package com.addoiles.mail;

import com.addoiles.mail.dto.Email;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 16:15
 */
public interface EmailService {

    Boolean sendEmail(Email email);

    void businessEmail(Email email);

}
