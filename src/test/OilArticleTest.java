import com.addoiles.entity.OilArticle;
import com.addoiles.service.OilArticleService;
import com.addoiles.util.JsonUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/8/3 10:45
 */
public class OilArticleTest extends BaseTest{

    @Resource
    private OilArticleService oilArticleService;

    @Test
    public void getDreams(){
        List<OilArticle> oilArticles = oilArticleService.selectsByType(1, 100);
        //均分
        Integer articleSize = oilArticles.size();
        Integer columnSize = 3; //左-中-右 3栏
        Integer avgPerColumn = articleSize / columnSize;

        if(articleSize%columnSize>0){ //取余大于0,余数放在最后一栏
            List<OilArticle> leftDreams = oilArticles.subList(0, avgPerColumn);
            List<OilArticle> midDreams = oilArticles.subList(avgPerColumn, avgPerColumn * 2);
            List<OilArticle> rightDreams = oilArticles.subList(avgPerColumn * 2, avgPerColumn * 3 + articleSize % columnSize);
            JsonUtils.toJson(leftDreams);
            JsonUtils.toJson(midDreams);
            JsonUtils.toJson(rightDreams);
        }
    }


}
