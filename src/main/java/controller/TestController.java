package controller;

import com.addoiles.db.redis.RedisService;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.dto.resp.LoginResp;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import com.addoiles.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    public static void main(String[] sf){
        startSpring();

        RedisService redisService = SpringContextUtils.getBean(RedisService.class);
//        redisService.set("33","asfasd");
        String s = redisService.get("33");
        System.out.println(s);
    }

    private static final String[] CONFIG_RESOUCES = new String[]{"application-context.xml"};
    private static volatile boolean running = true;
    private static ClassPathXmlApplicationContext springContext = null;
    private static void startSpring() {
        springContext = new ClassPathXmlApplicationContext(CONFIG_RESOUCES);
        springContext.start();


//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            if (springContext != null) {
//                springContext.stop();
//                springContext.close();
//                springContext = null;
//            }
//            synchronized (TestController.class) {
//                running = false;
//                TestController.class.notifyAll();
//            }
//        }));
//
//        synchronized (TestController.class) {
//            while (running) {
//                try {
//                    TestController.class.wait();
//                } catch (Throwable e) {
//                }
//            }
//        }
    }



}
