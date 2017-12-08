package controller;

import com.addoiles.dto.resp.LoginResp;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

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

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "sendCode", method = RequestMethod.GET)
    public Object sendCode() {
        VerificationCodeReq verificationCodeReq = new VerificationCodeReq();
        verificationCodeReq.setEmail("1743703238@qq.com");
        verificationCodeReq.setType(1);
        userService.sendVerificationCode(verificationCodeReq);

        return 0;
    }


}
