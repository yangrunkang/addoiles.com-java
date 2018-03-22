import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.dto.resp.LoginResp;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import com.addoiles.util.SpringContextUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import service.UserService;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 17:56
 */
public class OilTest {


    private static final String[] CONFIG_RESOUCES = new String[]{"application-context.xml"};
    private static volatile boolean running = true;
    private static ClassPathXmlApplicationContext springContext = null;
    private EmailService emailService;
    private UserService userService;

    public static void main(String[] sf) {
//        startSpring();
        testDeductImgSize();
//        testRedisGet();
//        testPub();

    }

    /**
     * 测试压缩图片
     */
    public static void testDeductImgSize() {
        try {
            Thumbnails.of(new File("D:\\wikipedia_pic\\test_pics.jpg"))
//                    .size(640, 480)
                    .scale(0.25f)
//                    .watermark(Watermark)
                    .outputQuality(0.8)
                    .outputFormat("jpg")
                    .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testSub() {
        StringRedisTemplate redisTemplate = SpringContextUtils.getBean(StringRedisTemplate.class);
    }

    /**
     * 测试发布
     */
    private static void testPub() {

        StringRedisTemplate redisTemplate = SpringContextUtils.getBean(StringRedisTemplate.class);
        redisTemplate.convertAndSend("testChannel", "from yrk");
    }

    private static void testRedisGet() {
        RedisService redisService = SpringContextUtils.getBean(RedisService.class);
        redisService.set("33", "asfasd");
        String s = redisService.get("33");
        System.out.println(s);
        redisService.delete("33");
        String s2 = redisService.get("33");
        System.out.println(s2);
    }

    private static void startSpring() {
        springContext = new ClassPathXmlApplicationContext(CONFIG_RESOUCES);
        springContext.start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (springContext != null) {
                springContext.stop();
                springContext.close();
                springContext = null;
            }
            synchronized (OilTest.class) {
                running = false;
                OilTest.class.notifyAll();
            }
        }));

        synchronized (OilTest.class) {
            while (running) {
                try {
                    OilTest.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

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

    public Object sendCode() {
        VerificationCodeReq verificationCodeReq = new VerificationCodeReq();
        verificationCodeReq.setEmail("1743703238@qq.com");
        verificationCodeReq.setType(1);
        userService.sendVerificationCode(verificationCodeReq);

        return 0;
    }


}
