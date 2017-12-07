package controller;

import com.addoiles.dto.LoginResp;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 17:56
 */
@Controller
public class TestController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "sendEmail", method = RequestMethod.GET)
    public Object sendEmail() {
        LoginResp loginResp = new LoginResp();
        Email email = new Email();

        Receiver receiver = new Receiver();
        receiver.setEmailAddress("1743703238@qq.com");
        receiver.setName("会飞的猪");

        email.setReceiver(receiver);
        email.setSubject("我是邮件主题-测试邮件基础服务");
        email.setContent("我是邮件正文-Hi,AddoilesEmail");



        emailService.sendEmail(email);

        return loginResp;
    }

}
