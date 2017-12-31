import com.addoiles.util.OilUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application*.xml")
public class OilUtilTest {

    @Test
    public void testGenerateID(){
        System.out.println(OilUtils.generateID());

    }


    public static void main(String[] args) {
        System.out.println(3/1);
        System.out.println(3/2);
        System.out.println(3/3);
    }


}
