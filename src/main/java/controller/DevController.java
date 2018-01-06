package controller;

import com.addoiles.db.dao.FirstPageMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.FirstPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Description: Dev 数据清理
 * All rights Reserved, Designed By HQYG
 * @apiNote 统一访问地址: http://ip:port/project_name/cleanRedisDevData
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/6 8:58
 */
@Controller
public class DevController {

    private static Logger logger = LoggerFactory.getLogger(DevController.class);

    @Resource
    private RedisService redisService;

    /**
     *  清除开发Redis Key
     * @return
     */
    @RequestMapping(value = "cleanRedisDevData",method = RequestMethod.GET)
    @ResponseBody
    public Object cleanRedisDevData(){
        redisService.deleteKeys(OilRedisConstant.OIL_WEBSITE + "*");
        logger.info("------>dev redis data cleaned");
        return "dev redis data cleaned";
    }


    @Resource
    private FirstPageMapper firstPageMapper;

    /**
     * 添加首页展示信息
     * @return
     */
    @RequestMapping(value = "addFirstPage",method = RequestMethod.GET)
    @ResponseBody
    public Object addFirstPage(@RequestBody FirstPage firstPage){
        Integer insert = firstPageMapper.insert(firstPage);
        return "----> addFirstPage result:" + insert;
    }

}
