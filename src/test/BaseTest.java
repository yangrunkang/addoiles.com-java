import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/8/3 10:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext*.xml")
public class BaseTest {

//    @Autowired
//    private ArticleMapper articleMapper;

    @Test
    public void test(){
//        List<Article> articles = articleMapper.selectAll();
//        System.out.println(JsonUtils.toJson(articles));
    }
}
