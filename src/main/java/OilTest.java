import com.addoiles.db.dao.ArticleMapper;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.dto.resp.LoginResp;
import com.addoiles.entity.Article;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import com.addoiles.util.SpringContextUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import service.UserService;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Yangrunkang
 * DateTime:  2017/12/7 17:56
 */
public class OilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OilTest.class);
    private static final String[] CONFIG_RESOUCES = new String[]{"application-context.xml"};
    private static volatile boolean running = true;
    private static ClassPathXmlApplicationContext springContext = null;
    private EmailService emailService;
    private UserService userService;

    public static void main(String[] sf) {
//        startSpring();
//        testDeductImgSize();
//        testRedisGet();
//        testPub();
        diff("E:\\diffTest\\A\\","E:\\diffTest\\B\\","E:\\diffTest\\DIFF\\");
    }


    /**
     * 比对文件名,如果文件名不符合,将原始文件复制到diffPath
     * @param originalFilePath 原始文件 文件较多
     * @param comparedFilePath 被匹配文件 文件较少且全部文件在originalFilePath中都包含
     * @param diffPath 差异文件地址
     */
    private static void diff(String originalFilePath, String comparedFilePath, String diffPath) {
        File originalDic = new File(originalFilePath);
        File comparedDic = new File(comparedFilePath);

        if (originalDic.isDirectory() && comparedDic.isDirectory()) {

            File[] originalFileList = originalDic.listFiles();
            File[] comparedFileList = comparedDic.listFiles();

            Boolean isOriginal = Objects.nonNull(originalFileList) && originalFileList.length <= 0;
            Boolean isCompared = Objects.nonNull(comparedFileList) && comparedFileList.length <= 0;
            if (!isOriginal && !isCompared && Objects.nonNull(originalFileList) && Objects.nonNull(comparedFileList)) {
                List<String> comparedNameList = Arrays.stream(comparedFileList).map(File::getName).collect(Collectors.toList());
                try {
                    for (File originalFile : originalFileList) {
                        String originalName = originalFile.getName();
                        if (!comparedNameList.contains(originalName)) {
                            FileUtils.copyFile(originalFile, new File(diffPath + "/" + originalName));
                            LOGGER.info(diffPath + "/" + originalName + "copied");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                LOGGER.error("one of dic no files");
            }
        } else {
            LOGGER.error("dic not exists");
        }
    }

    /**
     * 将base64位图片转换成img,替换进数据库
     */
    public static void replaceBase64ToImg() {

        ArticleMapper articleMapper = SpringContextUtils.getBean(ArticleMapper.class);
        List<Article> allArticles = articleMapper.getAllArticles();
        if (!CollectionUtils.isEmpty(allArticles)) {
            allArticles.forEach(article -> {
                //获取文章内容
                String content = article.getContent();
                //提取base64位图片并转换为img link并插入文本

            });
        }

    }

    /**
     * 把base64图片数据转为本地图片
     *
     * @param base64ImgData
     * @param filePath
     * @throws IOException
     */
    public static void convertBase64DataToImage(String base64ImgData, String filePath) throws IOException {
        BASE64Decoder d = new BASE64Decoder();
        byte[] bs = d.decodeBuffer(base64ImgData);
        FileOutputStream os = new FileOutputStream(filePath);
        os.write(bs);
        os.close();
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

    public void findBase64(String articleContnet) {

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
