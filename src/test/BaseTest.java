import com.addoiles.dao.ArticleMapper;
import com.addoiles.entity.Article;
import com.addoiles.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/8/3 10:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:application-datasource.xml"})
public class BaseTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void test(){
        List<Article> articles = articleMapper.selectAll();
        System.out.println(JsonUtils.toJson(articles));
    }
}
