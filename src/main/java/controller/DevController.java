package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.cache.OilCache;
import com.addoiles.db.dao.RecommendMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.Recommend;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

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
public class DevController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(DevController.class);

    @Resource
    private RedisService redisService;

    @Resource
    private OilCache oilCache;
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
    private RecommendMapper recommendMapper;

    /**
     * 添加首页展示信息
     * @param file 这种格式:fileType_fileName_file_desc
     * @return
     */
    @RequestMapping(value = "addFirstPage",method = RequestMethod.POST)
    @ResponseBody
    public Object addFirstPage(@RequestBody MultipartFile file) throws IOException {
        // 通过base64来转化图片
        String fileName = file.getOriginalFilename();

        String imagePath = "";
        Recommend recommend = new Recommend();
        recommend.setShowId(OilUtils.generateID());
        recommend.setImage(imagePath + "地址分割符号" + fileName);
        recommend.setDeleteStatus(DBFieldEnum.FirstPageDeleteStatus.NORMAL.getValue());
        recommend.setCreateTime(TimeUtil.currentTime());

        Integer insert = recommendMapper.insert(recommend);

        return "----> addFirstPage result:" + insert;
    }


    /**
     *  刷新首页图片
     * @return
     */
    @RequestMapping(value = "refreshFistPageImage",method = RequestMethod.GET)
    @ResponseBody
    public Object refreshFistPageImage(){
        redisService.deleteKeys(OilRedisConstant.FIRST_PAGE_IMAGE);
        logger.info("------>refreshFistPageImage Ok");
        oilCache.cacheFirstPageImage();
        return "refreshFistPageImage Ok";
    }


}
